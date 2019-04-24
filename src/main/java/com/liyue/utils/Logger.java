package com.liyue.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
*
 * 打印日志。。。
 *
 *
 */
@Component
@Aspect
public class Logger {

    @Pointcut("execution(* com.liyue.services.impl.*.*(..))")
    public  void pt1(){}


    @Before("pt1()")
    public   void   before(){
        System.out.println("开始打印日志啦。。。");
    }


   @AfterThrowing("pt1()")
    public   void  afterThrow(){
        System.out.println("有异常出现啦。。。");
    }

    @After("pt1()")
    public   void   after(){
        System.out.println("结束打印日志啦。。。");
    }


}
