package com.letv.ugc.aspect;



/**
 * Created by qiyongpeng on 2016/1/5.
 * 接口 API controller 切面
 */


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.letv.ugc.analyzer.common.exception.InvalidParamException;
import com.letv.ugc.common.NullParamException;
import com.letv.ugc.common.model.ApiCommonJsonResponse;
import com.letv.ugc.common.model.ApiCommonJsonResponseErrCodes;
import com.letv.ugc.common.utils.JsonUtils;

@Aspect
@Component
public class ApiControllerAspect {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(ApiControllerAspect.class);

    @Around("within(com.letv.ugc..api..controller..*)")
    public Object handle(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            result = joinPoint.proceed();
        }catch (NullParamException npe){
            result = ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.NULL_PARAM, npe.getLocalizedMessage());
        }catch (InvalidParamException npe){
        	result = ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.ERROR, npe.getLocalizedMessage());
        }catch (ClassCastException e){   //这里需要改进
        	result = ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.TOOLONG, e.getMessage());
        }
        catch(Throwable t){
            result = ApiCommonJsonResponse.newErrorResponse();
        }finally {
            logger.info(createLog(joinPoint, result));
        }
        return result;
    }

    private String createLog(JoinPoint joinPoint, Object result){
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("api interface ");
            sb.append(joinPoint.getSignature().toLongString());
            sb.append(", request params ");
            for (Object arg : joinPoint.getArgs()) {
                sb.append("[" + arg + "]");
            }
            sb.append(", response");
            sb.append("[" + JsonUtils.marshalToString(result) + "]");
        }catch (Exception e){
            logger.error("ApiControllerAspect create log err ", e);
        }
        return sb.toString();
    }

}
