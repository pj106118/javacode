package com.able.client.dao;

import com.able.client.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

/**
 * @author : panjing
 * @data : 2019/11/11 15:34
 * @describe :
 */
public class AccountDao extends BaseDao {

    //注册
     public boolean userReg(User user){
         Connection connection = null;
         PreparedStatement preparedStatement = null;

         try {
             connection = getConnection();
             String sql = "insert into user(username,password,brief) values (?,?,?)";
             preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

             preparedStatement.setString(1, user.getUserName());
             preparedStatement.setString(2, DigestUtils.md5Hex(user.getPassword()));
             preparedStatement.setString(3,user.getBrief());

             int rows = preparedStatement.executeUpdate();
             if(rows == 1){
                 return true;
             }
         } catch (SQLException e) {
             System.out.println("用户注册失败！");
             e.printStackTrace();
         }finally {
             closeResources(connection,preparedStatement);
         }
         return false;

     }

     //查询
     public User userLogin(String userName,String password){
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;

         try {
             connection = getConnection();
             String sql = "select * from user where userName = ? and password = ?";

             preparedStatement = connection.prepareStatement(sql);

             preparedStatement.setString(1,userName);
             preparedStatement.setString(2,DigestUtils.md5Hex(password));
             resultSet = preparedStatement.executeQuery();
             if(resultSet.next()){     //如果resultset中有值
                 User user = new User();
                 user.setId( resultSet.getInt("id"));
                 user.setUserName(resultSet.getString("userName"));
                 user.setPassword( resultSet.getString("password"));
                 user.setBrief(resultSet.getString("brief"));
                 return user;
             }
         } catch (SQLException e) {
             System.out.println("用户登录失败！");
            e.printStackTrace();
         }finally {
             closeResources(connection,preparedStatement,resultSet);
         }
         return null;
     }



}
