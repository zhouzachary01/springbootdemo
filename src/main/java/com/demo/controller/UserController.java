package com.demo.controller;

import com.demo.entity.ResultMap;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @description: 一句话描述功能;
 * @author: 周海涛
 * @date: 2018/6/10 10:57
 * @comment: 备注
 * @version: V1.0
 */
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    String resultMsg = "";

    @Autowired
    UserService userService;

    @Value("${com.battle.type}")
    private String ss1;

    @Value("${com.battle.title}")
    private String ss2;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){

        return "login/index";
    }
    @RequestMapping(value = "/success",method = RequestMethod.GET)
    public String success(){

        return "index/index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam Map<String,Object> params,HttpServletRequest request){

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        String sss = request.getHeader("user-agent");//获取浏览器的版本；
        System.out.println(ip);
        String loginName = (String)params.get("phone");
        String pass = (String)params.get("pass");
        ResultMap result = new ResultMap();
        User user = new User();
        user.setLoginName(loginName);
        user.setPass(pass);
        String username = user.getLoginName();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPass());
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        }catch(UnknownAccountException uae){
            //uae.printStackTrace();
            logger.error("msg:not find user");
            resultMsg = "not find user";
        }catch(IncorrectCredentialsException ice){
            //ice.printStackTrace();
            logger.error("msg:pass is error");
            resultMsg = "密码错误";
        }catch(LockedAccountException lae){
            //lae.printStackTrace();
            logger.error("msg:user is disabled");
            resultMsg = "该账号禁止登陆";
        }catch(ExcessiveAttemptsException eae){
            //eae.printStackTrace();
            //用户名或密码错误次数过多，稍后再试；
            logger.error("msg:please try again later");
        }catch(AuthenticationException ae){
            //ae.printStackTrace();
            logger.error("msg:validate is not pass");
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
        }catch (Exception e){
            e.printStackTrace();
        }

        //验证是否登录成功
        if(currentUser.isAuthenticated()){
            result.setStatus("200");
            result.setObj(user);
            System.out.println("验证成功");
        }else{
            token.clear();
            result.setStatus("400");
            result.setResultmessage(resultMsg);
            System.out.println("验证失败");
        }

        Object obj = currentUser.getPrincipal();

        return "index/index";
    }

    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    public String getUsers(ModelMap map){
        map.addAttribute("list",userService.getUsers());
        map.addAttribute("vvv",new Date().toString());
        return "login/hello";
    }

}
