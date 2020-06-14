package com.example.demo.model;

import com.example.demo.constant.ApiCode;

import java.io.Serializable;

/**
 * @author loocao
 * @date 2018-04-03
 */
public class RestResponseVO implements Serializable {
    private String code;
    private Object message;
    private Object data;

    public static RestResponseVO ok() {
        RestResponseVO result = new RestResponseVO();
        result.setCode(ApiCode.SUCCESS);
        result.setMessage("");
        return result;
    }

    public static RestResponseVO ok(Object data) {
        RestResponseVO result = ok();
        result.setData(data);
        return result;
    }

    public static RestResponseVO fail(String code, Object message) {
        RestResponseVO result = new RestResponseVO();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestResponseVO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
