package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 一句话描述功能;
 * @author: zxb
 * @date: 2018/11/8 9:27
 * @comment: 备注
 * @version: V1.0
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloController {


    @RequestMapping(value = "hello")
    public String hello(){
        return "login/hello";
    }


    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(MultipartFile file, HttpServletRequest request){

        return "test";
    }

}
