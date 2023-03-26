package com.demo.controller;

public class Code {
    public static final Integer SAVE_OK = 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer UPDATE_OK = 20031;
    // 单条记录
    public static final Integer GET_OK = 20041;
    // 多条记录
    public static final Integer GET_MULTI_OK = 20051;

    public static final Integer SAVE_ERROR = 20010;
    public static final Integer DELETE_ERROR = 20020;
    public static final Integer UPDATE_ERROR = 20030;
    public static final Integer GET_ERROR = 20040;
    public static final Integer GET_MULTI_ERROR = 20050;

    public static final Integer SYSTEM_ERROR = 50001;
    public static final Integer SYSTEM_TIMEOUT_ERROR = 50002;
    public static final Integer SYSTEM_UNKNOWN_ERROR = 59999;
    public static final Integer BUSINESS_ERROR = 60001;
}
