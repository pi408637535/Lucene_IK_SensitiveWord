package com.letv.ugc.aspect;



import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.letv.ugc.annotation.NullParamValidation;
import com.letv.ugc.common.NullParamException;

/**
 * Created by qiyongpeng on 2016/1/5.
 * 校验方法中参数是否为空的切面
 */
@Aspect
@Component
public class NullParamValidationAspect {

    /**
     * 校验方法中的参数是否为空，当有空的参数时抛出nullParamValidation异常
     * @param joinPoint
     * @param nullParamValidation
     * @throws NullParamException
     */
    @Before("within(com.letv.ugc..*) && @annotation(nullParamValidation)")
    public void validate(JoinPoint joinPoint, NullParamValidation nullParamValidation) throws NullParamException{
        List<Integer> nullIndexList = Lists.newArrayList();
        Object[] paramValues = joinPoint.getArgs();
        int[] ignoreFieldIndices = nullParamValidation.ignoreFieldIndices();

        for(int i = 0; i < paramValues.length; i++){
            if(ArrayUtils.contains(ignoreFieldIndices, i)){
                continue;
            }

            Object value = paramValues[i];
            if(value instanceof  String){
                if(StringUtils.isBlank((String)value)){
                    nullIndexList.add(i);
                }
            }else if(value instanceof List){
                if(CollectionUtils.isEmpty((List)value) ){
                    nullIndexList.add(i);
                }
            }else{
                if(value == null){
                    nullIndexList.add(i);
                }
            }
        }

        List<String> nullFileds = Lists.newArrayList();
        if(nullIndexList.size() > 0){
            for(int i = 0; i < nullIndexList.size(); i++) {
                if (paramValues.length == nullParamValidation.allFieldNames().length) {
                    nullFileds.add(nullParamValidation.allFieldNames()[i]);
                } else {
                    nullFileds.add("arg_" + i);
                }
            }
            throw new NullParamException(nullFileds, joinPoint.getSignature().toString());
        }
    }
}
