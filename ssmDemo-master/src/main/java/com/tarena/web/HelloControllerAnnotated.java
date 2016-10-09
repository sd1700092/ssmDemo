package com.tarena.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/hello")
public class HelloControllerAnnotated {

    @RequestMapping("/hello01/{name}")
    public String handleRequest(Model model,@PathVariable("name") String name) throws Exception {
        System.out.println("Hello World!");
        //调用业务层，如userService
       // httpServletRequest.setAttribute("message", "Hello World!");
        model.addAttribute("message", "Hello World!" + name);
        //转发到hello.jsp
        return "hello";
        //返回值发送给视图处理器
    }
}
