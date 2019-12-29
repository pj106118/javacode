package jing.able.Java.http.HTTPserver1;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : panjing
 * @data : 2019/12/27 19:44
 * @describe :  解析请求
 */
public class Request {

    String method;//方法
    String path;//路径
    String version;//版本
    Map<String,String> heads = new HashMap<>();  //请求头
    Map<String,String> parameters = new HashMap<>();
    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", heads=" + heads +
                '}';
    }

    public static Request parse(InputStream in) throws UnsupportedEncodingException {
        Request request = new Request();//要返回的request
        Scanner scanner = new Scanner(in,"UTF-8");//is是字节流，不态容易读一行

        String requestLine = scanner.nextLine();//解析请求行
        String[] str = requestLine.split(" ");
        request.method = str[0];
        Stringpath(request, str[1]);
        request.version = str[2];

        String line;
        //在找到空行前全都是请求头的内容
        while(!(line=scanner.nextLine()).isEmpty()){
            String[] group1 = line.split(":");
            String key = group1[0].trim();
            String value = group1[1].trim();
            request.heads.put(key,value);
        }
        return request;

    }

    private static void Stringpath(Request request, String s) throws UnsupportedEncodingException {
        //解析路径
        //1.路径部分考虑需要url解码
        //2.把QueryString 部分分离到Parameters中
        String[] group = s.split("\\?");
        request.path = group[0];
        if(group.length !=1){
            String[] kv = group[1].split("&");
            for(String kvs: kv){
                String[] kv1 = kvs.split("=");
                String key = URLDecoder.decode(kv1[0],"UTF-8");
                String value = "";
                if(kv1.length == 2){
                    value = URLDecoder.decode(kv1[1],"UTF-8");
                }
                request.parameters.put(key,value);
            }
        }
        request.path = URLDecoder.decode(request.path,"UTF-8");
    }
}
