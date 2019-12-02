use `piclib`;

-- 创建Session表
drop table if exists `SPRING_SESSION`;
create table `SPRING_SESSION`
(
    `PRIMARY_ID`            char(36)   not null default '',
    `SESSION_ID`            char(36)   not null default '',
    `CREATION_TIME`         bigint(20) not null,
    `LAST_ACCESS_TIME`      bigint(20) not null,
    `MAX_INACTIVE_INTERVAL` int(11)    not null,
    `PRINCIPAL_NAME`        varchar(100)        default null,
    `EXPIRY_TIME`           bigint(20)          default null,
    primary key (`PRIMARY_ID`) using btree,
    key                     `SPRING_SESSION_IX1`(`LAST_ACCESS_TIME`
) using btree
) engine = InnoDB
  default charset = `utf8mb4`;

drop table if exists `SPRING_SESSION_ATTRIBUTES`;
create table `SPRING_SESSION_ATTRIBUTES`
(
    `SESSION_PRIMARY_ID` char(36)     not null default '',
    `ATTRIBUTE_NAME`     varchar(100) not null default '',
    `ATTRIBUTE_BYTES`    blob,
    key                  `SPRING_SESSION_ATTRIBUTES_IX1`(`SESSION_PRIMARY_ID`
) using btree,
  constraint `SPRING_SESSION_ATTRIBUTES_ibfk_1` foreign key (`SESSION_PRIMARY_ID`) references `SPRING_SESSION` (`PRIMARY_ID`) on delete cascade
) engine = InnoDB
  default charset = `utf8mb4`;


-- 用户表
drop table if exists `t_user`;
create table if not exists `t_user`
(
    `id`            int unsigned auto_increment comment '用户ID',
    `username`      varchar(30)  not null comment '用户名',
    `password`      varchar(30)  not null comment '密码',
    `avatar`        varchar(150) not null comment '头像',
    `introduction`  varchar(150) not null comment '用户简介',
    `role`          varchar(60)  not null comment '角色',
    `isLocked`      tinyint(1)   not null comment '是否锁定',
    `lastLoginTime` datetime     not null comment '上次登录时间',
    `lastLoginIP`   varchar(15)  not null comment '上次登录IP',
    `isDeleted`     tinyint(1)   not null default false comment '是否删除',
    `createAt`      datetime     not null default CURRENT_TIMESTAMP comment '创建时间',
    `updateAt`      datetime     not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    `createBy`      int unsigned not null comment '创建者',
    primary key (`id`)
) charset = `utf8mb4`
  engine = InnoDB
  auto_increment = 1 comment ='用户表';


-- 素材类目表
drop table if exists `t_material_category`;
create table if not exists `t_material_category`
(
    `id`        int unsigned auto_increment comment '用户ID',
    `name`      varchar(30)  not null comment '类目名',
    `isDeleted` tinyint(1)   not null default false comment '是否删除',
    `createAt`  datetime     not null default CURRENT_TIMESTAMP comment '创建时间',
    `updateAt`  datetime     not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    `createBy`  int unsigned not null comment '创建者',
    primary key (`id`)
) charset = `utf8mb4`
  engine = InnoDB
  auto_increment = 1 comment ='素材类目表';

-- 许可协议表
drop table if exists `t_license`;
create table `t_license`
(
    `id`        int unsigned auto_increment comment '协议ID',
    `title`     varchar(64) not null comment '协议标题',
    `content`   mediumtext  not null comment '协议内容',
    `isDeleted` tinyint(1)  not null default false comment '是否删除',
    `createAt`  datetime    not null default CURRENT_TIMESTAMP comment '创建时间',
    `updateAt`  datetime    not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    primary key (`id`)
) charset `utf8mb4`
  engine = InnoDB
  auto_increment = 1 comment ='许可协议表';


-- 素材标签表
drop table if exists `t_material_tag`;
create table `t_material_tag`
(
    `id`        int unsigned auto_increment comment '标签ID',
    `matId`     int unsigned not null comment '素材ID',
    `tag`       varchar(32)  not null comment '标签名',
    `isDeleted` tinyint(1)   not null default false comment '是否删除',
    `createAt`  datetime     not null default CURRENT_TIMESTAMP comment '创建时间',
    `updateAt`  datetime     not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    primary key (`id`)
) charset = `utf8mb4`
  engine = InnoDB
  auto_increment = 1 comment ='素材标签关联表';


-- 用户关注表
drop table if exists `t_user_follow`;
create table `t_user_follow`
(
    `id`           int unsigned auto_increment comment '关注ID',
    `userId`       int unsigned not null comment '用户ID',
    `followUserId` int unsigned not null comment '另一个用户ID',
    `isDeleted`    tinyint(1)   not null default false comment '是否删除',
    `createAt`     datetime     not null default CURRENT_TIMESTAMP comment '创建时间',
    `updateAt`     datetime     not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    primary key (`id`)
) charset = `utf8mb4`
  engine = InnoDB
  auto_increment = 1 comment ='用户关注表';


-- 用户收藏表
drop table if exists `t_user_favor`;
create table `t_user_favor`
(
    `id`        int unsigned auto_increment comment '收藏ID',
    `userId`    int unsigned not null comment '用户ID',
    `matId`     int unsigned not null comment '素材ID',
    `isDeleted` tinyint(1)   not null default false comment '是否删除',
    `createAt`  datetime     not null default CURRENT_TIMESTAMP comment '创建时间',
    `updateAt`  datetime     not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    primary key (`id`)
) charset = `utf8mb4`
  engine = InnoDB
  auto_increment = 1 comment = '用户收藏表';


-- 素材表
drop table if exists `t_material`;
create table `t_material`
(
    `id`        int unsigned auto_increment comment '素材ID',
    `catId`     int unsigned  not null comment '素材类目ID',
    `name`      varchar(64)   not null comment '素材名字',
    `isDeleted` tinyint(1)    not null default false comment '是否删除',
    `license`   int unsigned  not null comment '许可协议',
    `desc`      varchar(1000) not null default '' comment '素材详情',
    `views`     int(10) unsigned not null default 0 comment '浏览数',
    `downs`     int(10) unsigned not null default 0 comment '下载数',
    `createAt`  datetime      not null default CURRENT_TIMESTAMP comment '创建时间',
    `updateAt`  datetime      not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    `createBy`  int unsigned  not null comment '创建者',
    primary key (`id`)
) charset = `utf8mb4`
  engine = InnoDB
  auto_increment = 1 comment = '素材表';

-- 素材附件表
drop table if exists `t_material_file`;
create table `t_material_file`
(
    `id`         int unsigned auto_increment comment '编号',
    `matId`      int unsigned comment '素材ID',
    `fileUrl`    varchar(150) not null comment '素材文件上传得到的URL',
    `fileFormat` varchar(32)  not null default '' comment '文件格式',
    `fileSize`   varchar(32)  not null default '' comment '文件大小',
    `desc`       varchar(128) not null default '' comment '文件描述',
    `measure`    varchar(32)  not null default '' comment '尺寸/分辨率',
    `colorSpace` varchar(32)  not null default '' comment '色彩空间',
    `isDeleted`  tinyint(1)   not null default false comment '是否删除',
    primary key (`id`)
) charset = `utf8mb4`
  engine = InnoDB
  auto_increment = 1 comment = '素材文件表';
create index `idx_t_material_file_matId` on `t_material_file` (`matId`);
create unique index `idx_t_material_file_matId_fileUrl_uni` on `t_material_file` (`matId`, `fileUrl`);

insert into `t_license`(`title`, `content`, `isDeleted`, `updateAt`)
    value ('CCE协议',
           '<p>Creative Commons （Exclusive distribution channel）</p><p><b class="warn">千图网内容详情页标示为（CCE协议）的作品，即遵循此授权协议，版权归属设计师与千图网共有。</b></p><p>CCE是千图网根据作品版权归属情况特别制定的一种特有的版权授权模式。您只需要购买网站VIP会员，在会员有效期以及VIP授权权限内，可以免费下载获取作品使用权，会员过期后，在会员有效期内下载并使用的作品可永久使用，不受时间、地域等的限制，且使用时无需署名。</p><p>您可以在授权范围内使用这张作品，如：<br>- <b class="warn">可商用</b>，也可学习，交流使用。<br>- <b class="warn">可下载，可编辑修改</b>这些作品。<br>- 使用时<b class="warn">无需署名</b><br></p><p>您不能：<br>- 转让，出售或出租任何千图网的作品（或千图网内容的修改版本）。<br>- 分发千图网的作品。<br>- 将千图网的作品储存在联机、脱机数据库或局域网中进行共享。<br>- 将千图网的作品（或千图网内容的修改版）提供给他人或其他机构，企业下载。<br>- 将千图网作品的版权占据为自己的版权。<br>- 下载有效期到期后，不得就千图网的作品再进行任何形式的使用，如直接使用、再创作、加工、衍生使用等。<br>- 其他千图网禁止以及法律禁止的事项。</p>',
           0, now());

select *
from `t_license`;

insert into `t_material_category`(`name`, `isDeleted`, `createAt`, `updateAt`, `createBy`)
values ('平面广告', false, now(), now(), 1),
       ('电商淘宝', false, now(), now(), 1),
       ('装饰装修', false, now(), now(), 1),
       ('网页UI', false, now(), now(), 1),
       ('视频音频', false, now(), now(), 1),
       ('产品工业', false, now(), now(), 1),
       ('PPT模板', false, now(), now(), 1),
       ('背景', false, now(), now(), 1),
       ('设计元素', false, now(), now(), 1),
       ('Excel模板', false, now(), now(), 1),
       ('简历模板', false, now(), now(), 1),
       ('Word模板', false, now(), now(), 1),
       ('新媒体用图', false, now(), now(), 1),
       ('插画绘画', false, now(), now(), 1),
       ('字库', false, now(), now(), 1),
       ('艺术字', false, now(), now(), 1),
       ('摄影图库', false, now(), now(), 1);


select *
from `t_material_category`;

insert into `t_user`(`username`, `password`, `avatar`, `introduction`, `role`, `updateAt`, `lastLoginTime`,
                     `lastLoginIP`, `isDeleted`, `isLocked`)
values ('admin', '111111', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'Super Admin',
        'admin', now(), now(), '0.0.0.0', false, false),
       ('editor', '111111', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'Normal Editor',
        'user', now(), now(), '0.0.0.0', false, false)



