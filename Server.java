package tcp.threads;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.concurrent.*;

public class Server {
    private static class TalkRunnable implements Runnable {
        private Socket clientSocket;

        TalkRunnable(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                InetAddress clientAddress = clientSocket.getInetAddress();
                int clientPort = clientSocket.getPort();
                System.out.printf("有客户端连接上来 %s:%d%n",
                        clientAddress.getHostAddress(), clientPort);
                // 获取 字节流
                InputStream is = null;
                is = clientSocket.getInputStream();
                // 字节流转换为字符流
                InputStreamReader isReader = null;
                isReader = new InputStreamReader(is, "UTF-8");
                // 字符流转换缓冲字符流
                BufferedReader reader = new BufferedReader(isReader);

                // 获取输出字节流
                OutputStream os = clientSocket.getOutputStream();
                PrintStream out = new PrintStream(os, true, "UTF-8");

                while (true) {
                    String line = reader.readLine();
                    System.out.println("好友说: " + line);
                    String response = "我已经收到了，" + System.currentTimeMillis();
                    out.println(response);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket tcpServerSocket = new ServerSocket(8080);
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ExecutorService pool = new ThreadPoolExecutor(
                100,
                100,
                0,
                TimeUnit.MILLISECONDS,
                queue
        );

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Socket clientSocket = tcpServerSocket.accept();
            pool.execute(new TalkRunnable(clientSocket));
        }
    }
}
