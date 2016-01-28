package com.letv.ugc.common;



import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.letv.ugc.common.utils.JsonUtils;

/**
 * Created by qiyongpeng on 2015/12/31.
 */
public class NullParamException extends RuntimeException{

    private List<String> nullFileds;

    private String extraMessage;

    public NullParamException(List<String> nullFileds, String extraMessage){
        this.nullFileds = nullFileds;
        this.extraMessage = extraMessage;
    }

    @Override
    public String getMessage(){
        String exceptionString =  "the parameters " + JsonUtils.marshalToString(nullFileds) + " can not be null";
        if(StringUtils.isNotBlank(extraMessage)){
            exceptionString += ", " + extraMessage;
        }
        return exceptionString;
    }

    @Override
    public String getLocalizedMessage(){
        return getMessage();
    }
}
