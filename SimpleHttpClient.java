package jing.able.Java.http.request;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : panjing
 * @data : 2019/12/21 15:15
 * @describe :  请求服务器并对服务器发回的响应进行解析，
 * 假设定义的 4096 字节已经包含 响应行 + 所有响应头 + 一部分正文，计算出剩下还需要读的数量
 */
public class SimpleHttpClient {
    public static void main(String[] args) throws IOException {
        String request = "GET / HTTP/1.0\r\nHost: www.baidu.com\r\n\r\n";

        Socket socket = new Socket("www.baidu.com", 80);
        socket.getOutputStream().write(request.getBytes("UTF-8"));
        // 版本   状态码     状态描述
        // 响应头打印
        // 把响应正文保存下来
        byte[] bytes = new byte[4096];
        int len = socket.getInputStream().read(bytes);
        // 假设 4096 字节已经包含 响应行 + 所有响应头 + 一部分正文
        int index = -1;
        for (int i = 0; i < len - 3; i++) {
            if (bytes[i] == '\r' && bytes[i+1] == '\n' && bytes[i+2] == '\r' && bytes[i+3] == '\n') {
                index = i;
                break;
            }
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes, 0, index + 4);
        Scanner scanner = new Scanner(byteArrayInputStream, "UTF-8");
        String statusLine = scanner.nextLine();
        String[] result = statusLine.split(" ");
        System.out.println("协议版本："+result[0]);
        System.out.println("状态码："+result[1]);
        System.out.println("状态码描述信息："+result[2]);
        String line;
        int contentLength = -1; //正文长度，是在响应中给出的，需要找到
        while (!(line = scanner.nextLine()).isEmpty()) {
            String[] kv = line.split(":");
            String key = kv[0].trim();  //trim是用来去除空格，使左右对称
            String value = kv[1].trim();
            System.out.println("响应头: " + key + " = " + value);
            if(key.equalsIgnoreCase("Content-Length")){
                contentLength = Integer.valueOf(value);
            }
        }
        System.out.println(contentLength);
        int overread = len - index - 4; //已经读了的数目
        int needread = contentLength - overread ; //还需再读的数目

        byte[] body = new byte[contentLength];
        System.arraycopy(bytes,index+4,body,0,overread);
        int realyread = socket.getInputStream().read(body,overread,needread);//实际读了的数目

        System.out.println(overread);
        System.out.println(needread);
        System.out.println(realyread);

    }
}
