package com.example.demo.constant;

/**
 * 接口常用响应码
 *
 * @author loocao - 2018/1/8
 */
public class ApiCode {
    /**
     * 成功
     */
    public static final String SUCCESS = "200";
    /**
     * 客户端错误
     */
    public static final String BAD_REQUEST = "400";
    /**
     * 未认证
     */
    public static final String UNAUTHORIZED = "401";
    /**
     * 拒绝执行
     */
    public static final String FORBIDDEN = "403";
    /**
     * 不是会员
     */
    public static final String NOT_AGENT = "40301";
    /**
     * Not Found
     */
    public static final String NOT_FOUND = "404";
    /**
     * 冲突验证
     */
    public static final String CONFLICT = "409";
    /**
     * 服务器错误
     */
    public static final String INTERNAL_SERVER_ERROR = "500";

    /**
     * 支付超时
     */
    public static final String PAY_OVERTIME = "600";
}
