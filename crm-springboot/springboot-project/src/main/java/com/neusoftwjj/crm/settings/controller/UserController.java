package com.neusoftwjj.crm.settings.controller;


import com.neusoftwjj.crm.commons.contants.Contants;
import com.neusoftwjj.crm.commons.domain.ReturnObject;
import com.neusoftwjj.crm.commons.utils.DateUtils;
import com.neusoftwjj.crm.settings.model.User;
import com.neusoftwjj.crm.settings.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/settings/qx/user/toLogin.do")
    public String toLogin(){
        return "settings/qx/user/login";
    }

    @GetMapping("/settings/qx/user/login.do")
    @ResponseBody
    public Object login(String loginAct, String loginPwd, String isRemPwd, HttpServletRequest request, HttpSession session, HttpServletResponse response){
        //封装参数
        Map<String,Object> map=new HashMap<>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        //调用service层方法,查询用户
        User user =userService.queryUserByLoginActAndPwd(map);
        //根据查询结果,生成响应信息
        ReturnObject returnObject=new ReturnObject();
        if(user==null){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名或密码错误");
        }else {
            //调Date数据处理方法
            String nowStr = DateUtils.formateDateTime(new Date());
            if (nowStr.compareTo(user.getExpireTime()) > 0) {
                //过期,登录失败
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("用户登录过期");
            } else if ("0".equals(user.getLockState())) {
                //状态锁定,登录失败
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("用户状态被锁定");
            } else if (!user.getAllowIps().contains(request.getRemoteAddr())) {
                //IP地址不合法,登录失败
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("用户名地址不合法");
            } else {
                //登录成功
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("登录成功");
                //将user保存在session中
                session.setAttribute(Contants.SESSION_USER,user);
                //记住密码,写cookie
                if("true".equals(isRemPwd)){
                    Cookie c1=new Cookie("loginAct",user.getLoginAct());
                    c1.setMaxAge(10*24*60*60);
                    response.addCookie(c1);
                    Cookie c2=new Cookie("loginPwd",user.getLoginPwd());
                    c2.setMaxAge(10*24*60*60);
                    response.addCookie(c2);
                }else{
                    //把没有过期的cookie删除
                    Cookie c1=new Cookie("loginAct","1");
                    c1.setMaxAge(0);
                    response.addCookie(c1);
                    Cookie c2=new Cookie("loginPwd","1");
                    c2.setMaxAge(0);
                    response.addCookie(c2);
                }
            }
        }
        return returnObject;
    }

    //用户安全退出
    @GetMapping("/settings/qx/user/logout.do")
    public String logout(HttpServletResponse response,HttpSession session){
        //清空cookie
        Cookie c1=new Cookie("loginAct","1");
        c1.setMaxAge(0);
        response.addCookie(c1);
        Cookie c2=new Cookie("loginPwd","1");
        c2.setMaxAge(0);
        response.addCookie(c2);
        //销毁session
        session.invalidate();
        //跳转首页
        return "redirect:/";//借助springmvc实现的重定向
    }

    //用户打开系统设置
    @GetMapping("/settings/index.do")
    public String SystemSetting(){
        return "settings/index";
    }
}
