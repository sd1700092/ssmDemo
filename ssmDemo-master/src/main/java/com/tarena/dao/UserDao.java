package com.tarena.dao;

import com.tarena.entity.User;

/**
 * 数据层 持久化层
 * 实体对象的CURD
 * Created by SkyOne on 2016/10/6.
 */

public interface UserDao {
    User findByName(String name);
//    Integer add(User user);
//    void delete(User user);
//    void update(User user);
//    List<User> findAll();
//    User findById(Integer id);
}
