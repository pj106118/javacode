package jing.able;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : panjing
 * @data : ${data},${time}
 * @describe :
 */
public class SingleThreadServer {
    public static void main(String[] args) throws IOException {
        //服务器端

        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("等待客户端连接。。。。。");
        Socket client = serverSocket.accept();
        System.out.println("与客户端连接成功，端口号为"+client.getPort());

        //接收客户端发来的消息
        Scanner in = new Scanner(client.getInputStream());
        if(in.hasNext()){
            System.out.println("客户端发来的消息为"+in.nextLine());
        }

        //向客户端发消息
        PrintStream out = new PrintStream(client.getOutputStream());
        out.print("hi");

        in.close();
        out.close();
        serverSocket.close();

    }
}
