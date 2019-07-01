package com.llfy.demo.tool;

public class MessageResult {
    public static <T> ResponseMessage<T> success(String code, String message) {
        return new ResponseMessage<T>(code,message);
    }

    public static <T> ResponseData<T> success(String code, String message,T data) {
        return new ResponseData<T>(code,message,data);
    }
}
