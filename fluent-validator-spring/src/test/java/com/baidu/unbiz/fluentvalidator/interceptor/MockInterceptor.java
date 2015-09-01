package com.baidu.unbiz.fluentvalidator.interceptor;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author zhangxu
 */
@Component
@Aspect
public class MockInterceptor {

    @Around("execution(* com.baidu.unbiz.fluentvalidator.service.impl.CarServiceImpl.*(..))")
    public Object validate4AjaxQuery(ProceedingJoinPoint pjp) throws Throwable {
        MethodInvocationProceedingJoinPoint methodJoinPoint = (MethodInvocationProceedingJoinPoint) pjp;
        MethodSignature methodSignature = (MethodSignature) methodJoinPoint.getSignature();
        System.out.println("here we enter aspectJ interceptor");
        Object[] args = pjp.getArgs();
        System.out.println(Arrays.asList(args));
        System.out.println(methodSignature);

        return pjp.proceed();
    }

}
