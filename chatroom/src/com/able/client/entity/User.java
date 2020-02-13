package com.able.client.entity;

import lombok.Data;

/**
 * @author : panjing
 * @data : 2019/11/11 15:44
 * @describe :  user表的实体类    基本类型一定要使用包装类
 */

@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String brief;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }



}
