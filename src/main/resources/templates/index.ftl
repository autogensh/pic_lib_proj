<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/element-ui@2.12.0/lib/theme-chalk/index.css">
    <link rel="stylesheet" href="css/iconfont.css">
    <title>首页</title>
    <style>
        * {
            border: 0;
            vertical-align: baseline;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            list-style: none;
            margin: 0;
            padding: 0;
            font-style: normal;
            text-decoration: none;
            font-family: PingFangSC-Regular, sans-serif, PingFangSC-Light, sans-serif, "Microsoft YaHei", arial;
            text-align: left;
            font-size: 14px;
            font-weight: 500;
            color: #666;
        }
        body {
            background-color: #ffffff;
        }
        .fl {
            float: left
        }
        .fr {
            float: right
        }
        .footer1 {
            height: 200px;
            padding: 25px 40px;
        }
        .footer1 dl {
            width: 150px;
        }
        .footer1 dt {
            margin-bottom: 10px;
            font-size: 14px;
            font-weight: 700;
            color: #666;
        }
        .footer1 dd {
            font-size: 12px;
            line-height: 2;
            color: #888;
        }
        .footer1 .service {
            width: 300px;
            position: relative;
        }
        .footer1 .service p {
            margin-bottom: 15px;
        }
        .footer1 .service .service-title {
            color: #666;
            font-size: 18px;
            font-weight: 700;
        }
        .footer1 .service .service-email {
            color: #666;
            font-size: 18px;
        }
        .footer2 {
            margin: 0 30px;
            border-top: solid 1px #ccc;
            height: 45px;
            line-height: 45px;
            text-align: center;
            font-size: 12px;
            color: #888;
        }
        .page-header-banner {
            height: 340px;
        }
        .page-header {
            width: 100%;
            height: 68px;
            background: rgba(255, 255, 255, 0.25);
            /*background: #66CCFF;*/
        }
        .el-carousel {
            position: absolute;
            top: 0;
        }
        .bg-purple-light {
            background: #f5f5f5;
        }
        .el-carousel__item {
            height: 300px;
        }
        .el-carousel__item h3 {
            color: #475669;
            font-size: 18px;
            opacity: 0.75;
            line-height: 340px;
            margin: 0;
            text-align: center;
        }
        .el-carousel__item:nth-child(2n) {
            background-color: #99a9bf;
        }
        .el-carousel__item:nth-child(2n+1) {
            background-color: #d3dce6;
        }
        .el-row {
            margin-bottom: 20px;
        }
        .el-card {
            width: 100%;
        }
        .el-button--primary * {
            color: #FFF;
        }
        .time {
            font-size: 12px;
            color: #999;
        }
        .bottom {
            margin-top: 13px;
            line-height: 12px;
        }
        .button {
            padding: 0;
            float: right;
        }
        .image {
            width: 100%;
            display: block;
        }
        .clearfix:before,
        .clearfix:after {
            display: table;
            content: "";
        }
        .clearfix:after {
            clear: both
        }
        #scroll-top {
            /*display: none;*/
            position: fixed;
            right: 20px;
            bottom: 20px;
            width: 40px;
            height: 40px;
            line-height: 40px;
            background-color: rgba(0, 0, 0, 0.4);
            color: #fff;
            font-size: 18px;
            cursor: pointer;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            -ms-border-radius: 2px;
            border-radius: 2px;
            text-align: center;
            z-index: 100;
            -webkit-box-sizing: content-box;
            -moz-box-sizing: content-box;
            box-sizing: content-box;
        }
    </style>
</head>

<body><a id="scroll-top" class="scroll-top-right" href="#" style="display: block;"><span class="fa fa-angle-up"></span></a>
<div id="app">
    <!-- page header -->
    <el-row style="margin:0">
        <el-col :span="24">
            <div class="page-header">page-header</div>
        </el-col>
    </el-row>
    <!-- banner -->
    <el-row class="page-header-banner">
        <el-col :span="24">
            <el-carousel :interval="5000" type="card" arrow="always" style="width:100%; height:100%">
                <el-carousel-item v-for="item in 6" :key="item">
                    <h3>{{ item }}</h3>
                </el-carousel-item>
            </el-carousel>
        </el-col>
    </el-row>
    <div style="width: 100%; padding: 0 20px">
        <el-row :gutter="20">
            <el-col :span="6" v-for="(o, index) in 10" :key="o" style="margin:10px 0">
                <el-card :body-style="{padding:'10px 10px'}" shadow="hover">
                    <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                         class="image">
                    <div style="padding: 14px;">
                        <span>好吃的汉堡</span>
                        <div class="bottom clearfix">
                            <time class="time" v-text="currentDate"></time>
                            <el-button type="text" class="button">操作按钮</el-button>
                        </div>
                    </div>
                </el-card>
            </el-col>
        </el-row>
    </div>
    <el-row style="margin: 0">
        <el-col :span="24">
            <div class="bg-purple-light footer1">
                <dl class="fl">
                    <dt>常见问题</dt>
                    <dd>成为特邀设计师</dd>
                    <dd>注册登录</dd>
                    <dd>账号/密码</dd>
                    <dd>发票/售后</dd>
                    <dd>版权投诉</dd>
                </dl>
                <dl class="fl">
                    <dt>关于</dt>
                    <dd>关于我们</dd>
                    <dd>加入我们</dd>
                </dl>
                <dl class="fl">
                    <dt>产品服务</dt>
                    <dd>官方博客</dd>
                    <dd>帮助中心</dd>
                </dl>
                <div class="fr service">
                    <p class="service-title">客服咨询</p>
                    <p class="service-qq">
                        <el-button type="primary"><i class="icon-QQ"></i>点我交谈</el-button>
                    </p>
                    <p class="service-email"><i class="icon-contact"></i>aaaabbbb@email.com</p>
                </div>
            </div>
        </el-col>
        <el-col :span="24" class="bg-purple-light">
            <div class="footer2">
                Copyright ©2018-2019 图库网 备案号12341234号 ICP证书 公安备案12123412341234号
            </div>
        </el-col>
    </el-row>
</div>
</body>

<script src="https://cdn.bootcss.com/axios/0.19.0/axios.min.js"></script>
<script src="https://cdn.bootcss.com/vue/2.6.10/vue.js"></script>
<script src="https://cdn.bootcss.com/element-ui/2.12.0/index.js"></script>
<script src="https://cdn.jsdelivr.net/npm/moment"></script>
<script>
    var data = {
        currentDate: moment().format('YYYY-MM-DD HH:mm:ss')
    };
    new Vue({
        el: '#app',
        data: data
    });
</script>
</html>
