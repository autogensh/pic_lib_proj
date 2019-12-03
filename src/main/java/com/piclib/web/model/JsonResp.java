package com.piclib.web.model;

public class JsonResp {
    public int code;
    public String message;

    // default constructor: success
    public JsonResp() {
        this.setSuccess();
    }

    public JsonResp(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setSuccess() {
        this.code = 20000;
        this.message = "success";
    }

    public static Object success() {
        return new JsonResp();
    }

    public static Object serializeError() {
        return new JsonResp(-1, "序列化错误！");
    }

    public static Object databaseInsertError() {
        return new JsonResp(-2, "服务器忙，请过会儿重试！");
    }

    public static Object usernameOrPasswordError() {
        return new JsonResp(-3, "账号或者密码错误！");
    }

    public static Object uploadFileError() {
        return new JsonResp(-4, "上传失败，请重新上传试试！");
    }

    public static Object unauthorizedOperation() {
        return new JsonResp(-5, "没有操作权限！");
    }

}
