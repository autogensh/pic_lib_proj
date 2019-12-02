package com.piclib.web.model;

import java.util.Date;

public class UserInfoResp extends JsonResp {
    public Integer id;
    public String username;
    public String avatar;
    public String introduction;
    public Date lastLoginTime;
    public String lastLoginIP;
}
