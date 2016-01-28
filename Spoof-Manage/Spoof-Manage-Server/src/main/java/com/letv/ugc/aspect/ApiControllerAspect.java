package com.letv.ugc.aspect;




import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.letv.ugc.common.NullParamException;
import com.letv.ugc.common.model.ApiCommonJsonResponse;
import com.letv.ugc.common.model.ApiCommonJsonResponseErrCodes;
import com.letv.ugc.common.utils.JsonUtils;

@Aspect
@Component
public class ApiControllerAspect {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(ApiControllerAspect.class);

    @Around("within(com.letv.ugc..api..service..*)")
    public Object handle(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            result = joinPoint.proceed();
        }catch (NullParamException npe){
            result = ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.NULL_PARAM, npe.getLocalizedMessage());
        }catch(Throwable t){
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
