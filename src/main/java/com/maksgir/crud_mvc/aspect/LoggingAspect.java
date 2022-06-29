package com.maksgir.crud_mvc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
    @Around("execution(* com.maksgir.crud_mvc.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvise(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String methodName = methodSignature.getName();

        System.out.println("Begin of " + methodName);

        Object target = proceedingJoinPoint.proceed();

        System.out.println("End of " + methodName);

        System.out.println("********************************");

        return target;
    }
}
