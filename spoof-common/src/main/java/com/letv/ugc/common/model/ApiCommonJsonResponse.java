package com.letv.ugc.common.model;

import java.util.Map;

import com.google.common.collect.Maps;

public class ApiCommonJsonResponse {
	private boolean ret;
    private Map<String, Object> data;
    private String errMsg;
    private int errCode;
    
    public ApiCommonJsonResponse(){
    	
    }
    
    private ApiCommonJsonResponse(String dataKey, Object dataValue){
        ret = true;
        data = Maps.newHashMap();
        data.put(dataKey, dataValue);
    }

    private ApiCommonJsonResponse(ApiCommonJsonResponseErrCodes errCode, String errMsg){
        ret = false;
        this.errCode = errCode.getCode();
        this.errMsg = errMsg;
    }

    public static ApiCommonJsonResponse newNormalResponse(String dataKey, Object dataValue){
        return new ApiCommonJsonResponse(dataKey, dataValue);
    }

    public static ApiCommonJsonResponse newErrorResponse(ApiCommonJsonResponseErrCodes errCode, String errMsg){
        return new ApiCommonJsonResponse(errCode, errMsg);
    }

    public static ApiCommonJsonResponse newErrorResponse(){
        return newErrorResponse(ApiCommonJsonResponseErrCodes.DEFAULT, "api exception");
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
