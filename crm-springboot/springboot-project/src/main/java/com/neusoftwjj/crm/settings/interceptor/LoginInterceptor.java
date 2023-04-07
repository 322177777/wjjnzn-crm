package com.neusoftwjj.crm.settings.interceptor;


import com.neusoftwjj.crm.commons.contants.Contants;
import com.neusoftwjj.crm.settings.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //用户没登录,则跳转登录页面,判断session
        HttpSession session=httpServletRequest.getSession();
        User user=(User) session.getAttribute(Contants.SESSION_USER);
        if(user == null){
            httpServletResponse.sendRedirect("/");//重定向,url加项目名称
            return false;
        }
        return true;
    }

}
