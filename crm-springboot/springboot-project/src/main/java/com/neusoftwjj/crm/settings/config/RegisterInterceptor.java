package com.neusoftwjj.crm.settings.config;

import com.neusoftwjj.crm.settings.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RegisterInterceptor implements WebMvcConfigurer {
    //添加拦截器对象,注入容器中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();
        //指定拦截的请求uri地址
        String path [] = {"/settings/**","/workbench/**"};
        //不拦截的地址
        String excludePath [] = {"/settings/qx/user/toLogin.do","/settings/qx/user/login.do"};
        registry.addInterceptor(interceptor).addPathPatterns(path).excludePathPatterns(excludePath);
    }
}
