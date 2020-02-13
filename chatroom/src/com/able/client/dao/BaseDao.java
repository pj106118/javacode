package com.able.client.dao;

import com.able.util.CommUtil;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author : panjing
 * @data : 2019/11/11 15:17
 * @describe :  dao层的基础层，封装数据源、获取连接、关闭资源等共有操作
 */
public class BaseDao {
    //1.加载数据源
    private static DruidDataSource DATASOURCE;
    static {
        Properties properties = CommUtil.loadProperties("db.properties");
        try {
            DATASOURCE = (DruidDataSource) DruidDataSourceFactory.
                    createDataSource(properties);
        } catch (Exception e) {
            System.out.println("加载数据源失败！");
            e.printStackTrace();
        }
    }

    //2.获取连接
    protected Connection getConnection(){
        try {
            return (Connection) DATASOURCE.getPooledConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //4.关闭资源
    protected void closeResources(Connection connection,
                                  Statement statement){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeResources(Connection connection,
                               Statement statement,
                               ResultSet resultSet){
        closeResources(connection,statement);
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
