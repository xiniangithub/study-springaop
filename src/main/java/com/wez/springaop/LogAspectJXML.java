package com.wez.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类
 * 使用XML配置方式
 */
public class LogAspectJXML {

    /**
     * 前置增强
     * @param joinPoint 连接点对象
     */
    public void before(JoinPoint joinPoint) {
        System.out.println("---------- 前置增强 ----------");
        System.out.println(joinPoint.getSignature().getName());
    }

    /**
     * 后置增强
     * @param joinPoint 连接点对象
     * @param obj 切点方法的返回值
     */
    public void afterReturning(JoinPoint joinPoint, Object obj) {
        System.out.println(obj);
    }

    /**
     * 异常增强
     * @param joinPoint 连接点对象
     * @param e
     */
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常增强：" + e);
    }


    /**
     * 最终增强
     * @param joinPoint 连接点对象
     */
    public void after(JoinPoint joinPoint) {
        System.out.println("---------- 最终增强 ----------");
    }

    /**
     * 环绕通知
     * @param joinPoint 连接点对象
     * @return
     * @throws Throwable
     */
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

}
