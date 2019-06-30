package jing.able;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : panjing
 * @data : ${data},${time}
 * @describe :
 */
public class SingleThreadlient {
    public static void main(String[] args) throws IOException {
        //客户端

        Socket client = new Socket("127.0.0.1",8888);
        System.out.println("服务器端连接成功。。。。");

        //向服务器端发出消息
        PrintStream out = new PrintStream(client.getOutputStream());
        out.println("hi");


        //接受服务器端发来消息
        Scanner in = new Scanner(client.getInputStream());
        if(in.hasNext()){
            System.out.println("服务器端发来的消息为"+in.nextLine());
        }
        in.close();
        out.close();

    }
}
