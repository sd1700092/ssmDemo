package cn.gxufe.ssm.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 燕赤侠 2016-09-24
 */
@Controller
@RequestMapping("/page")
public class PageController {


    @RequestMapping("{path}")
    public String page(@PathVariable("path") String path){
        return path;
    }

}
