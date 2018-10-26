package com.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/6/10 15:09
 * @comment: 备注
 * @version: V1.0
 */
//@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    //如果返回json，需要@ResponseBody注解；如果返回页面，则不需要
    public String resultError(){

        return "error";
    }


}
