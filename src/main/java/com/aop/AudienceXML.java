package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/29 15:01
 * @Description:  普通Java类 演出 前后
 */
public class AudienceXML {

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

    public void silenceCellPhones(){
        System.out.println("表演前请把手机调成振动或者是关机状态！");
    }

    public void takeSeats(){
        System.out.println("Taking seats 找座！");
    }

    public void applause(){
        System.out.println("CLAP CLAP CLAP 啪 啪 啪 ！！！");
    }

    public void demandRefund(){
        System.out.println("Demanding a refund 观众会要求退款");
    }

}
