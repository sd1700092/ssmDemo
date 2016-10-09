package com.tarena.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SkyOne on 2016/10/6.
 */
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("Hello World!");
        //调用业务层，如userService
        httpServletRequest.setAttribute("message", "Hello World!");
        //转发到hello.jsp
        return new ModelAndView("hello");
        //返回值发送给视图处理器
    }
}
