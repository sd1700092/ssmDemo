package com.tarena.web;

import javax.servlet.http.HttpServletRequest;

//@Controller
//@RequestMapping("/demo")//父路径
/**
 * Created by SkyOne on 2016/10/7.
 */
public class HelloKittyController {
    //请求路径：/demo/hello.form
//    @RequestMapping("/hello.form")//子路径
    public String execute(HttpServletRequest req)
            throws Exception{
        System.out.println("执行HelloKitty");
        req.setAttribute("message", "Hello Kitty!");
        return "hello";//转发到hello.jsp
    }
}
