package com.tarena.service;

import com.tarena.dao.UserDao;
import com.tarena.entity.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by SkyOne on 2016/10/6.
 */
@Service("userServiceDay04")
public class UserServiceDay04 implements Serializable {
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
    public User login(String name, String pwd){
        final User user = userDao.findByName(name);
        if(user == null){
            return null;
        }
        if(user.getPwd().equals(pwd)){
            return user;
        }
        return null;//密码不一致
    }
}
