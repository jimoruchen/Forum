package com.example.entity;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

public record RestBean<T>(int code, T data, String msg) {
    public static <T> RestBean<T> success(T data) {
        return new RestBean<>(200, data, "请求成功");
    }

    public static <T> RestBean<T> success() {
        return success(null);
    }

    public static <T> RestBean<T> unauthorized(String msg) {
        return failure(401, msg);
    }

    public static <T> RestBean<T> forbidden(String msg) {
        return failure(403, msg);
    }

    public static <T> RestBean<T> failure(int code, String msg) {
        return new RestBean<>(code, null, msg);
    }

    public String asJsonString() {
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }
}
