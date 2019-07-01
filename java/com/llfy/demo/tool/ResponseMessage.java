package com.llfy.demo.tool;

public class ResponseMessage<T> {
    private String code;
    private String msg;
    public ResponseMessage() {
    }
    public ResponseMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
