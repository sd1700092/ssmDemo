package com.tarena;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBC的连接管理
 * Created by SkyOne on 2016/10/5.
 */
@Component("dataSource")
//@Component("ds")
public class JdbcDataSource implements Serializable {
    @Value("#{jdbc.driver}")
    private String driver;
    @Value("#{jdbc.url}")
    private String url;
    @Value("#{jdbc.user}")
    private String user;
    @Value("#{jdbc.pwd}")
    private String pwd;

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, pwd);
        return conn;
    }

    public String getDriver() {
        return driver;
    }

    @Value("#{jdbc.driver}")
    public void setDriver(String driver) {
        this.driver = driver;
        try{
            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("驱动！", e);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 关闭连接的方法
     * JdbcDataSource
     */
    public void close(Connection conn){
        try{
            if(conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
