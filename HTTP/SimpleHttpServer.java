package jing.able.Java.http.HTTPserver1;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : panjing
 * @data : 2019/12/27 18:55
 * @describe : 写一个简单的HTTP服务器
 */
public class SimpleHttpServer {
    static class Task implements Runnable{
        Socket socket = new Socket(); //相当于一个用户
        Task(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream(); //读取用户端的输入流
                OutputStream os = socket.getOutputStream();//读取用户端的输出流

                Request request = Request.parse(in);  //解析请求 ，request 对象代表用户需求

                // 处理业务
                if(request.path.equalsIgnoreCase("/")) { //如果是根目录（不区分大小写）
                    String body = "<h1>成功</h1>";
                    byte[] bodybuffer = body.getBytes("UTF-8");
                    StringBuilder response = new StringBuilder();
                    response.append("http/1.0 ok 200\r\n");
                    response.append("Content-type:text/html;charset=UTF-8\r\n");//text/plain是纯文本，text/HTML是以网页形式
                    response.append("Content-Length:" + bodybuffer.length + "\r\n");
                    response.append("\r\n");

                    os.write(response.toString().getBytes("UTF-8"));
                    os.write(bodybuffer);
                    os.flush();
                }else if(request.path.equalsIgnoreCase("/banjia")){
                    StringBuilder response = new StringBuilder();
                    response.append("HTTP/1.0 307 Temporary Redirect\r\n");
                    response.append("Location:/\r\n");
                    response.append("\r\n");
                    os.write(response.toString().getBytes("UTF-8"));
                    os.flush();

                }else{
                    String body = "<h1>你要找的页面找不到了</h1>";
                    StringBuilder response = new StringBuilder();
                    response.append("HTTP/1.0 404 notFound\r\n");
                    response.append("Content-type:text/html;charset=UTF-8\r\n");

                    response.append("\r\n");
                    os.write(response.toString().getBytes("UTF-8"));

                    os.write(body.getBytes("UTF-8"));
                    os.flush();
                }

            socket.close();
            }catch (Exception e){}
        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80); //创建一个监听Socket，端口为80
        ExecutorService pool = Executors.newFixedThreadPool(10);//创建容量为10的线程池
        while(true){
            Socket socket = serverSocket.accept();  //该方法没有人来之前不会返回，返回的是一个通信socket
            pool.execute(new Task(socket));
        }
    }
}
