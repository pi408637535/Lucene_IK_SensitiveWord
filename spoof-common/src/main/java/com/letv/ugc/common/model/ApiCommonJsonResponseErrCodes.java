package com.letv.ugc.common.model;


/**
 * Created by qiyongpeng on 2016/1/5.
 */
public enum ApiCommonJsonResponseErrCodes{
    DEFAULT(500),
    NULL_PARAM(501),
    VAGUE(1),
    TOOLONG(2),
    TOOShort(3),  
    CORRECT(0)
    ;

    private int code;

    private ApiCommonJsonResponseErrCodes(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}