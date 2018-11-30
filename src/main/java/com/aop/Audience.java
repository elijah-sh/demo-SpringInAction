package com.aop;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/29 15:01
 * @Description:  演出 前后
 */
@Aspect
public class Audience {

  public void watchPerformance(ProceedingJoinPoint joinPoint){
      try{
          // 开始前
          System.out.println("手机静音");
          System.out.println("占个走位");

          joinPoint.proceed(); // 执行被通知的方法
            // 成功之后
          System.out.println("表演的不赖！");
      }catch (Throwable e){
          // 失败时
          System.out.println("表演的不中，退票！");
      }
  }


    /**************************
     * 新的方法
     */

    /**
     * 定义命名的切点
     */
    @Pointcut("execution(* com.aop.Performance.perform(..))")
    public void Performance(){}

    @Before("Performance()")
    public void silenceCellPhonesNew(){
        System.out.println("表演前请把手机调成振动或者是关机状态！");
    }

    @Before("Performance()")
    public void takeSeatsNew(){
        System.out.println("Taking seats 找座！");
    }

    @AfterReturning("Performance()")
    public void applauseNew(){
        System.out.println("CLAP CLAP CLAP 啪 啪 啪 ！！！");
    }

    @AfterThrowing("Performance()")
    public void demandRefundNew(){
        System.out.println("Demanding a refund 观众会要求退款");
    }



    /**************************
     * 旧的方法   相同的切点表达式我们重复了四遍
     */

    /**
     * 表演前
     */
    @Before("execution(* com.aop.Performance.perform(..))")
    public void silenceCellPhones(){

        System.out.println("表演前请把手机调成振动或者是关机状态！");
    }

    /**
     * 在演出之前， 观众要就坐
     */
    @Before("execution(* com.aop.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("Taking seats 找座！");
    }

    /**
     * 表演之后  鼓掌  演出成功
     */
    @AfterReturning("execution(* com.aop.Performance.perform(..))")
    public void applause(){
        System.out.println("CLAP CLAP CLAP 啪 啪 啪 ！！！");
    }

    /**
     * 表演失败之后 观众会要求退款
     */
    @AfterThrowing("execution(* com.aop.Performance.perform(..))")
    public void demandRefund(){
        System.out.println("Demanding a refund 观众会要求退款");
    }
}
