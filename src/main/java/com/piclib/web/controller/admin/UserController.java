package com.piclib.web.controller.admin;

import com.piclib.web.dao.AdminMapper;
import com.piclib.web.dao.UserMapper;
import com.piclib.web.entity.User;
import com.piclib.web.entity.UserExample;
import com.piclib.web.model.JsonResp;
import com.piclib.web.model.UserInfoResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends TController<User, UserExample, UserMapper> {
    private static final String basePath = "/admin/user";

    @Autowired
    public UserController(UserMapper mapper, UserExample example, AdminMapper adminMapper) {
        super(mapper, example, adminMapper);
    }

    @GetMapping(basePath + "/info")
    public Object getUserInfo() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfoResp resp = new UserInfoResp();
        resp.username = user.getUsername();
        resp.avatar = user.getAvatar();
        resp.introduction = user.getIntroduction();
        resp.lastLoginIP = user.getLastLoginIP();
        resp.lastLoginTime = user.getLastLoginTime();
        return resp;
    }

    @GetMapping(basePath + "/list")
    public Object getList() {
        return super.getList("id asc");
    }

    @GetMapping(basePath + "/update")
    public Object update(User e) {
        return super.update(e);
    }

    @GetMapping(basePath + "/del")
    public Object delete(User e) {
        return super.delete(e);
    }

    @PostMapping(basePath + "/lock")
    public Object lock(@RequestBody User u) {
        User _u = new User();
        _u.setIsLocked(u.getIsLocked());
        _u.setUpdateAt(u.getUpdateAt());
        super.example.clear();
        super.example.createCriteria().andIdEqualTo(u.getId());
        int result = super.mapper.updateByExampleSelective(_u, super.example);
        if (result == 1) {
            return JsonResp.success();
        }
        return JsonResp.databaseInsertError();
    }
}
