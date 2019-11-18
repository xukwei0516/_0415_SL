package com.sy.interceptor;

import com.sy.model.common.User;
import com.sy.tools.Constants;
import com.sy.tools.RedisAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 对用户想访问的url进行拦截
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisAPI redisAPI;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        System.out.println("------拦截器被调用-------");

        String reqUrl = request.getRequestURI();

        User sessionUser = (User)request.getSession().getAttribute(Constants.SESSION_USER);

        String key = Constants.FUNURLS+sessionUser.getRoleId();

        String allowedUrls = redisAPI.get(key);

        //redisAPI.flushDB();

        //String allowedUrls2 = redisAPI.get(key);

        if("".equals(allowedUrls)||allowedUrls==null||!allowedUrls.contains(reqUrl)){
            //跳转到401.jsp
            request.getRequestDispatcher("/WEB-INF/pages/401.jsp").
                    forward(request, response);
            return false;
        }

        return true;
    }
}
