package jing.able;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : panjing
 * @data :
 * @describe : 基于多线程的服务器端
 */
public class MultiThreadServer {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(22);
        ServerSocket serverSocket = new ServerSocket(6666);
        for (int i = 0; i < 20; i++) {
            System.out.println("等待客户端连接...");
            Socket client = serverSocket.accept();
            System.out.println("有新的客户端连接，端口号为: " + client.getPort());
            executorService.submit(new ExecuteClient(client));
        }
        executorService.shutdown();
        serverSocket.close();

    }
       //存储所有注册客户端
       private static Map<String, Socket> clientMap = new ConcurrentHashMap<String, Socket>();
       //具体处理与每个客户端通信的内部类
       private static class ExecuteClient implements Runnable{
           private Socket client;
           private ExecuteClient(Socket client) {
               this.client = client;
           }
           @Override
           public void run() {
               //客户端输入流
               try {
                   Scanner in = new Scanner(client.getInputStream());
                   String str =null;
                   while(true) {
                       if(in.hasNext()){
                           str = in.nextLine();
                           //注册
                           if (str.startsWith("R")){  //判断一个字符串是否以某个前缀开始
                               String useName = str.split(":")[1];
                               registerUser(useName,client);
                               break;
                           }
                           //群聊  G：1-msg
                           if (str.startsWith("G")){
                               String useName = str.split(":")[1];
                               String msg = str.split("-")[1];
                               groupChar(msg);
                               break;
                           }
                           //私聊  P：1-msg
                           if (str.startsWith("P")){
                               String useName = str.split(":")[1];
                               String msg = str.split("-")[1];
                               privateChat(useName,msg);
                               break;
                           }
                           //退出
                           if (str.contains("byebye")){
                               String userName = null;
                               for (String keyName:clientMap.keySet()) {
                                   //查找是哪一个用户输出拜拜
                                   if (clientMap.get(keyName).equals(client)){
                                       userName = keyName;
                                   }
                               }
                               System.out.println("用户"+userName+"已下线");
                               clientMap.remove(userName);
                               break;
                           }
                       }
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           //注册流程
           private void registerUser(String useName, Socket client) throws IOException {
               System.out.println("用户名为"+useName +"上线了！");
               System.out.println("当前群聊人数为："+(clientMap.size()+1) +"人");
               //将用户的信息存入map中
               clientMap.put(useName,client);
               PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
               System.out.println(useName+"用户注册成功");

           }
           //群聊流程
           private void groupChar(String msg) {
               Set<Map.Entry<String,Socket>> clientSet = clientMap.entrySet();
               for(Map.Entry<String,Socket> entry: clientSet ){
                   Socket socket = entry.getValue();
                   try {
                       PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
                       out.print("群聊消息为"+msg);
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }
           //私聊程序
           private void privateChat(String useName, String msg) throws IOException {
               Socket privateSocket = clientMap.get(useName);
               PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
               out.print("输出消息为："+msg);
           }
       }
}
