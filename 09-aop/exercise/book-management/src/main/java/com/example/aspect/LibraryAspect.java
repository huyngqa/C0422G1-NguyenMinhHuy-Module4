package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LibraryAspect {
    private int view = 0;
    @Before(value =
    "execution(* com.example.controller.LibraryController.*(..))")
    public void logViewBook(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        view += 1;
        System.err.println("Bạn đã ghé " + methodName);
        System.err.println("Lượt view: " + view);
    }

    @AfterReturning(pointcut = "execution(* com.example.controller.LibraryController.rentBook(..))")
    public void logChangeBookForRent(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.err.println("Bạn đã vào " + methodName + " và thay đổi trạng thái sách");
    }

    @AfterReturning(pointcut = "execution(* com.example.controller.LibraryController.payBook(..))")
    public void logChangeBookForPay(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.err.println("Bạn đã vào " + methodName + " và thay đổi trạng thái sách");
    }
}
