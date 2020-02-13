package com.able.server;

import com.able.util.CommUtil;
import com.able.vo.MessageVO;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : panjing
 * @data : 2019/11/19 13:57
 * @describe :    支持多线程的服务端
 */
public class MultiThreadServer {
    private static final Integer PORT;
    static {
        Properties pros = CommUtil.loadProperties("socket.properties");
        PORT = Integer.valueOf(pros.getProperty("PORT"));
        //配置文件默认都是String类型的
    }
    // 服务端缓存所有连接的客户端对象
    private static Map<String, Socket> clients
            = new ConcurrentHashMap<>();
    /*
    使用ConcurrentHashMap的原因：
    要考虑线程安全问题：
    如果有多个客户端与服务器连接，恰好用户名重复了，就出现了线程安全问题。
     */


    //服务端具体处理客户端请求的任务
    private static class ExecuteClient implements Runnable{
        private Socket client;
        private Scanner in;
        private PrintStream out;

        ExecuteClient(Socket client){
            this.client = client;
            try {
                this.in = new Scanner(client.getInputStream());
                this.out = new PrintStream(client.getOutputStream(),
                        true,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            while(true){
                if(in.hasNextLine()){
                    String strFromClient = in.nextLine();
                    MessageVO msgFromClient = (MessageVO) CommUtil.json2Object(strFromClient,
                            MessageVO.class);
                    if(msgFromClient.getType().equals(1)){
                        //新用户注册
                        String userName = msgFromClient.getConent();
                        //将当前聊天室在线好友信息发回给新用户
                        Set<String> names = clients.keySet();
                        MessageVO msg2Client = new MessageVO();
                        msg2Client.setType(1);
                        msg2Client.setConent(CommUtil.object2Json(names));
                        out.println(CommUtil.object2Json(msg2Client));
                        //将新用户的上线信息发给其他在线用户
                        String loginMsg = "newLogin:" + userName;
                        /**
                         * clients.values() 取出map中的所有value值
                         */
                        for(Socket socket: clients.values()){
                            try {
                                PrintStream out = new PrintStream(socket.getOutputStream(),
                                        true,"UTF-8");
                                out.println(loginMsg);
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        //将新用户信息保存到当前服务器端
                        System.out.println(userName+"上线了！");
                        clients.put(userName,client);
                        System.out.println("当前聊天室在线人数为：" + clients.size());
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //1.建立基站
        ServerSocket server = new ServerSocket(PORT);

        //用线程池新建线程支持多个客户端连接
        ExecutorService executors = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            System.out.println("等待客户端连接····");
            //一直阻塞，直到有客户端与它连接，就返回客户端对象，继续向下执行
            Socket client = server.accept();
            System.out.println("有新的连接，端口号为："+client.getPort());
            executors.submit(new ExecuteClient(client));//处理客户端连接的任务

        }

    }
}
