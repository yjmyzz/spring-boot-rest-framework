package spring.boot.rest.common.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import spring.boot.rest.common.consts.RestConst;
import spring.boot.rest.common.model.DataResult;
import spring.boot.rest.common.validator.ParamValidator;

import java.util.ArrayList;
import java.util.Map;


/**
 * 记录服务层方法参数,并对参数进行校验,同时监控方法执行时间
 *
 * @since: 15/11/21.
 * @author: yangjunming
 */
@Aspect
@Component
public class ServiceMonitor {

    private Logger logger = LoggerFactory.getLogger(ServiceMonitor.class);


    @Around("execution(* spring.boot.rest.demo..*Controller.*(..))")
    public Object logServiceAccess(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();

        String className = pjp.getTarget().getClass().getName();
        String fullMethodName = className + "." + pjp.getSignature().getName();

        boolean needLog = false;

        //记录参数,并对参数进行校验
        if (!className.contains("com.sun.proxy.$Proxy") && !className.contains("$$EnhancerBySpringCGLIB$$")) {
            needLog = true;
            if (pjp.getArgs() != null && pjp.getArgs().length > 0) {
                logger.info(fullMethodName + "将被调用,下面是参数:");
                for (Object arg : pjp.getArgs()) {
                    logger.info(arg.toString());
                    Map<String, ArrayList<String>> validateResult = ParamValidator.validator(arg);
                    if (validateResult != null) {
                        for (Map.Entry<String, ArrayList<String>> entry : validateResult.entrySet()) {
                            logger.error(fullMethodName + "参数:" + arg);
                            logger.error(entry.getKey() + "校验失败,原因:" + entry.getValue());

                            long end = System.currentTimeMillis();
                            long elapsedMilliseconds = end - start;
                            logger.info(fullMethodName + "执行耗时:" + elapsedMilliseconds + " 毫秒");

                            return new DataResult<String>(RestConst.ErrorCode.VALIDATE_FAIL, entry.getKey() + ":"
                                    + entry.getValue(), elapsedMilliseconds);
                        }
                    }
                }
            } else {
                logger.info(fullMethodName + "将被调用");
            }
        }

        Object result = null;
        try {
            result = pjp.proceed();
            if (result instanceof DataResult) {
                ((DataResult<?>) result).setIsSuccess(true);
            }
        } catch (Throwable e) {

            if (result != null && result instanceof DataResult) {
                DataResult<?> errorResult = (DataResult<?>) result;
                errorResult.setIsSuccess(false);
                if (StringUtils.isEmpty(errorResult.getErrorCode())) {
                    errorResult.setErrorCode(RestConst.ErrorCode.UNKNOWN);
                }
                if (StringUtils.isEmpty(errorResult.getErrorDesc())) {
                    errorResult.setErrorDesc(e.getLocalizedMessage());
                }
            } else {
                result = new DataResult<Object>(RestConst.ErrorCode.UNKNOWN, e.getMessage());
            }
            logger.error(fullMethodName + "执行出错,详情:", e);

            if (e instanceof DataAccessException) {
                //数据库层面的异常,继续向上抛,否则事务无法回滚
                ((DataResult<Object>) result).setErrorCode(RestConst.ErrorCode.DATABASE_ERROR);
            }
        }


        long end = System.currentTimeMillis();
        long elapsedMilliseconds = end - start;
        if (needLog) {
            logger.info(fullMethodName + "执行耗时:" + elapsedMilliseconds + " 毫秒");
        }

        if (result != null && result instanceof DataResult) {
            ((DataResult<?>) result).setElapsedMilliseconds(elapsedMilliseconds);
        }

        return result;
    }
}
