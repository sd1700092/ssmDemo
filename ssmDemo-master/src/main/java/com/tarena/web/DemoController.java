package com.tarena.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SkyOne on 2016/10/8.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/hello.form")
    public String hello(ModelMap map){
        map.put("msg", "Hello");
        System.out.println("Hello Controller");
        return "success";
    }

    @RequestMapping("/demo.form")
    public String demo() throws Exception{
        String s = null;
        if(s == null){
            throw new DemoException("测试异常");
        }
        return "success";
    }
}
