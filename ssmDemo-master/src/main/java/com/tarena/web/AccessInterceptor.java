package com.tarena.web;

import com.tarena.entity.User;
import com.tarena.util.Consts;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SkyOne on 2016/10/8.
 */
public class AccessInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute(Consts.LOGIN_USER);
        if(user == null){
            // 如果没有登录，重定向到登录页面
            final String path = /*httpServletRequest.getContextPath() + */"login/login.form";
            httpServletResponse.sendRedirect(path);
            return false;//不执行任何的控制器了
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
