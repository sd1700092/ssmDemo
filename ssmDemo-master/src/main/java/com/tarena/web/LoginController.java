package com.tarena.web;

import com.tarena.entity.User;
import com.tarena.service.NameOrPwdException;
import com.tarena.service.NullParamException;
import com.tarena.service.UserServiceDay05;
import com.tarena.util.Consts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SkyOne on 2016/10/7.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Resource
    private UserServiceDay05 userService;
//    /login/login.form -> login.jsp
    //显示登录表单界面
    @RequestMapping("/login.form")
    public String login(){
        return "login";
    }

    @RequestMapping("/login-action1.form")
    public String loginAction1(HttpServletRequest request) throws NameOrPwdException, NullParamException {
        final String name = request.getParameter("name");
        final String pwd = request.getParameter("pwd");
        User user = userService.login(name, pwd);
        if(user == null){
            request.setAttribute("name1", "用户名或密码错误");
            request.setAttribute("pwd1", "用户名或密码错误");
            return "login";
        }
        //保持用户登录状态！
        request.getSession().setAttribute(Consts.LOGIN_USER, user);
        request.setAttribute("msg", "欢迎" + user.getName());
        System.out.println(name + ", " + pwd);
        return "success";//success.jsp
    }

    @RequestMapping("/login-action2.form")
    public String loginAction2(String name, String pwd,
                               HttpServletRequest request) throws NameOrPwdException, NullParamException {
        User user = userService.login(name, pwd);
        if(user == null){
            request.setAttribute("name2", "用户名或密码错误");
            request.setAttribute("pwd2", "用户名或密码错误");
            return "login";
        }
        //保持用户登录状态！
        request.getSession().setAttribute(Consts.LOGIN_USER, user);
        request.setAttribute("msg", "欢迎" + user.getName());
        System.out.println(name + ", " + pwd);
        return "success";//success.jsp
    }

    @RequestMapping("/login-action3.form")
    public String loginAction3(FormBean bean, HttpServletRequest request) throws NameOrPwdException, NullParamException {
        User user = userService.login(bean.getName(), bean.getPwd());
        if(user == null){
            request.setAttribute("name3", "用户名或密码错误");
            request.setAttribute("pwd3", "用户名或密码错误");
            return "login";
        }
        //保持用户登录状态！
        request.getSession().setAttribute(Consts.LOGIN_USER, user);
        request.setAttribute("msg", "欢迎" + user.getName());
        System.out.println(bean.getName() + ", " + bean.getPwd());
        return "success";//success.jsp
    }

    @RequestMapping("/login-action4.form")
    public ModelAndView loginAction4(String name, String pwd,
                                     HttpServletRequest request){
        Map<String ,String> map = new HashMap<>();
        if(name == null || name.trim().equals("")){
            map.put("name4", "必须输入用户");
        }
        if(pwd == null || pwd.trim().equals("")){
            map.put("pwd4", "必须输入密码");
        }
        //只要用户不输入信息，我就跳回到原登陆页
        if(! map.isEmpty()){
            return new ModelAndView("login", map);
        }
        try {
            final User user = userService.login(name, pwd);
            //登陆成功
            request.getSession().setAttribute(Consts.LOGIN_USER, user);
            map.put("message", "欢迎" + user.getName());
            return new ModelAndView("success", map);
        } catch (NameOrPwdException e) {
            //登陆失败
            e.printStackTrace();
            map.put("msg4", e.getMessage());
            return new ModelAndView("login", map);
        } catch (NullParamException e) {
            //登陆失败
            e.printStackTrace();
            map.put("msg4", e.getMessage());
            return new ModelAndView("login", map);
        }
    }

    @RequestMapping("/login-action5.form")
    public String loginAction5(@ModelAttribute("name") String name, String pwd, ModelMap model,
                               HttpServletRequest request){
//        model.put("msg", "Hi");
//        model.addAttribute("name5", "不能空");
        boolean error = false;
        if(name == null || name.trim().equals("")){
            model.put("name5", "必须输入用户");
            error = true;
        }
        if(pwd == null || pwd.trim().equals("")){
            model.put("pwd5", "必须输入密码");
            error = true;
        }
        //只要用户不输入信息，我就跳回到原登陆页
        if(error){
            //但是如果用户输了用户名，没输密码，我可以在转发时把
            //他输过的用户名保存下来
//            model.addAttribute("name", name);
            return "login";
        }
        try {
            final User user = userService.login(name, pwd);
            //登陆成功
            request.getSession().setAttribute(Consts.LOGIN_USER, user);
            model.put("message", "欢迎" + user.getName());
            return "success";
        } catch (NameOrPwdException e) {
            //登陆失败
            e.printStackTrace();
            model.put("msg5", e.getMessage());
            return "redirect:login.form";
        } catch (NullParamException e) {
            //登陆失败
            e.printStackTrace();
            model.put("msg5", e.getMessage());
            return "login";
        }
    }

    /**  全局的Attribute，所有的请求中都有  **/
    @ModelAttribute("message")
    public String getMessage(){
        return "通知：今天雾霾严重！";
    }
}
