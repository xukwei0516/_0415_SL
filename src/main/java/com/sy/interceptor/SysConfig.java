package com.sy.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Springmvc文件
@Configuration
public class SysConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration registration = registry.addInterceptor(interceptor);

        //该LoginInterceptor要拦截的URL

        //1.静态资源不能被拦截

        //2.登录页面访问不能拦截

        //3.登录操作不能拦截

        //4.跳转main.html不能被拦截

        registration.addPathPatterns("/**").excludePathPatterns("/statics/**","/login.html","/main.html","/error","/");
    };
}
