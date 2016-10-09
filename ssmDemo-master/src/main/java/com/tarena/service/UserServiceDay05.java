package com.tarena.service;

import com.tarena.dao.UserDao;
import com.tarena.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by SkyOne on 2016/10/6.
 */
@Service("userService")
public class UserServiceDay05 implements Serializable {
    @Resource
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 登录功能方法
     * @param name
     * @param pwd
     * @return
     */
    public User login(String name, String pwd)
            throws NameOrPwdException, NullParamException{
        //检验输入参数是否合理！
        if(name == null || name.trim().equals("")){
            throw new NullParamException("木有名");
        }
        if(pwd == null || pwd.trim().equals("")){
            throw new NullParamException("木有密");
        }
        final User user = userDao.findByName(name);
        if(user == null){
            throw new NameOrPwdException("木有！");
        }
        if(user.getPwd().equals(pwd)){
            return user;
        }
        throw new NameOrPwdException("密码啥呀");//密码不一致
    }
}
