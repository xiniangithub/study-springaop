package com.wez.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * 使用注解的方式
 */
@Component
@Aspect // 定义切面
public class LogAspectJAnnotation {

    /**
     * 前置增强
     * @param joinPoint 连接点对象
     */
    @Before("execution(* com.wez.svc.*.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("---------- 前置增强 ----------");
        System.out.println(joinPoint.getSignature().getName());
    }

    /**
     * 后置增强
     * @param joinPoint 连接点对象
     * @param obj 切点方法的返回值
     */
    @AfterReturning(value="execution(* com.wez.svc.*.*(..))", returning="obj")
    public void afterReturning(JoinPoint joinPoint, Object obj) {
        System.out.println(obj);
    }

    /**
     * 异常增强
     * @param joinPoint 连接点对象
     * @param e
     */
    @AfterThrowing(value="execution(* com.wez.svc.*.*(..))", throwing="e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常增强：" + e);
    }


    /**
     * 最终增强
     * @param joinPoint 连接点对象
     */
    @After("execution(* com.wez.svc.*.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("---------- 最终增强 ----------");
    }

    /**
     * 环绕通知
     * @param joinPoint 连接点对象
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.wez.svc.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("..........环绕增强前..........");
        long startTime = System.currentTimeMillis();

        // 获取方法参数，可以通过该方式修改参数
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length >= 0) {
            for (Object arg : args) {
                System.out.println(arg);
            }
        }

        Object obj = joinPoint.proceed(args); // 调用目标对象的方法

        long endTime = System.currentTimeMillis();
        System.out.println("执行时间：" + (endTime - startTime));
        System.out.println("..........环绕增强后..........");
        return obj;
    }

    /*
        Before、After、AfterReturning、Around都可以获取方法参数，但只有Around可以修改方法参数。
     */


    /**
     * 定义公共切点表达式
     */
    @Pointcut(value="execution(* com.wez.svc.*.*(..))")
    public void test() {

    }

    /**
     * 引用公共切点
     */
    @Before(value="test()")
    public void before2() {
        System.out.println("公共切点");
    }







}
