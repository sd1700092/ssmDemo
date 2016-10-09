package com.tarena.dao;

import com.tarena.JdbcDataSource;
import com.tarena.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 在MySqL数据库上实现的实体方法DAO
 * Created by SkyOne on 2016/10/6.
 */
@Repository("userDao")
public class MySQLUserDao implements Serializable, UserDao {
    @Resource
    private JdbcDataSource dataSource;

    public JdbcDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(JdbcDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User findByName(String name) {
        String sql = "select id, name, pwd, phone " +
                "from RegUser where name=?";
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            final PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            final ResultSet rs = ps.executeQuery();
            User user = null;
            if(rs.next()){
                user = rowToUser(rs);
            }
            ps.close();
            return user;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            dataSource.close(conn);
        }
        return null;
    }

    private User rowToUser(ResultSet rs) throws Exception {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setPwd(rs.getString("pwd"));
        user.setPhone(rs.getString("phone"));
        return user;
    }


}
