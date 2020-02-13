package com.able.client.service;

import com.able.client.dao.AccountDao;
import com.able.client.entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author : panjing
 * @data : 2019/11/12 14:16
 * @describe :
 */
public class UserReg {
    private JPanel regPanel;
    private JTextField userNameTest;
    private JPasswordField passwordTest;
    private JTextField briefTest;
    private JButton 提交信息Button;

    private AccountDao accountDao = new AccountDao();

    public UserReg() {
        //调用构造方法就能产生登录界面
        JFrame frame = new JFrame("用户注册");  //标题名
        frame.setContentPane(regPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  //居中显示页面（默认在左上角显示）
        frame.pack();
        frame.setVisible(true);

        //点击提交按钮触发此方法
        提交信息Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1.获取界面上三个控件的内容
                String userName = userNameTest.getText();
                String password = String.valueOf(passwordTest.getPassword());
                String brief = briefTest.getText();
                //2.调用dao层方法将信息持久化到数据库
                User user = new User();
                user.setUserName(userName);
                user.setPassword(password);
                user.setBrief(brief);
                if (accountDao.userReg(user)) {
                    //注册成功,弹出提示框提示用户信息注册成功
                    //返回登录页面
                    JOptionPane.showMessageDialog(null,
                            "注册成功","成功信息",
                            JOptionPane.INFORMATION_MESSAGE);
                    //最后一个是提示框类型（是成功or失败） 当前是成功的

                    //让注册页面消失
                    frame.setVisible(false); //值为true就是可见的，false就是消失

                } else {
                    //注册失败，弹出提示框提示用户注册失败
                    //保留当前注册页面
                    JOptionPane.showMessageDialog(null,
                            "注册失败","失败信息",
                            JOptionPane.ERROR_MESSAGE);
                    //最后一个是提示框类型（是成功or失败） 当前是失败的
                }
            }
        });
    }

}
