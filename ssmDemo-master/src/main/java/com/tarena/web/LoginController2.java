package com.tarena.web;

import com.tarena.entity.User;
import com.tarena.service.NameOrPwdException;
import com.tarena.service.NullParamException;
import com.tarena.service.UserServiceDay05;
import com.tarena.util.Consts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by SkyOne on 2016/10/8.
 */
@Controller
@RequestMapping("/login")
public class LoginController2 {
    @Resource
    private UserServiceDay05 userService;
    @RequestMapping("/login-action6.form")
    public String loginAction(String name, String pwd, HttpServletRequest request)
    throws Exception{
        final User user = userService.login(name, pwd);
        request.getSession().setAttribute(Consts.LOGIN_USER, user);
        return "success";
    }

    /**
     * 当控制器方法执行出现异常时候执行
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler
    public String execute(HttpServletRequest request, Exception e) throws Exception{
        if(e instanceof NullParamException){
            request.setAttribute("message6", "参数为空！");
            return "login";
        }else if(e instanceof NameOrPwdException){
            request.setAttribute("message6", "用户名或者密码错误");
            return "login";
        }
        throw e;
    }
}
