package com.piclib.web.model;

public class LoginSuccessResp extends JsonResp {
    public String token;

    public LoginSuccessResp(String token) {
        this.setSuccess();
        this.token = token;
    }
}
