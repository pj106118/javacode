package jing.able;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : panjing
 * @data :
 * @describe :  基于多线程的客户端
 */
public class MultiThreadClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1",6666);
            Thread readFromServer = new Thread(new ReadFromServerThread(client));
            Thread writeToServer = new Thread(new WriteToServerThread(client));
            readFromServer.start();
            writeToServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReadFromServerThread implements Runnable {
    private Socket client;

    public ReadFromServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // 获取客户端输入流
        Scanner in = null;
        try {
            in = new Scanner(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            if (in.hasNext()) {
                System.out.println("从服务器发来的消息为: " + in.next());
            }
            // 客户端退出
            if (client.isClosed()) {
                System.out.println("客户端已关闭");
                break;
            }
        }
        in.close();
    }
}
// 将信息发送给服务器线程
class WriteToServerThread implements Runnable {
    private Socket client;

    public WriteToServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {


        try {
            // 获取键盘输入
            Scanner scanner = new Scanner(System.in);
            // 获取客户端输出流
            PrintStream out = new PrintStream(client.getOutputStream());
            while (true) {
                System.out.println("请输入要发送的消息..");
                String strToServer;
                if (scanner.hasNextLine()) {
                    strToServer = scanner.nextLine().trim();
                    out.println(strToServer);
                    // 客户端退出标志
                    if (strToServer.equals("byebye")) {
                        System.out.println("关闭客户端");
                        scanner.close();
                        out.close();
                        client.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}