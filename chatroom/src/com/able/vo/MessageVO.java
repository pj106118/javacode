package com.able.vo;


import lombok.Data;

/**
 * @author : panjing
 * @data : 2019/11/19 16:28
 * @describe :  服务端与客户端通信的载体
 */

@Data
public class MessageVO {
    /**
     * 告知服务端要进行的操作，eg:1表示新用户的注册，2表示私聊，3表示群聊
     */
    private Integer type;
    /**
     * 服务端与客户端聊天的具体内容
     */
    private String conent;
    /**
     * 聊天信息发送的目标客户端名称
     */
    private String to;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getConent() {
        return conent;
    }

    public void setConent(String conent) {
        this.conent = conent;
    }
}
