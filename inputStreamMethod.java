//获取输入流的四种方法
public static InputStream inputStreamMethod() throws IOException {
        /* 第一种：从文件中读
        InputStream inputStream = new FileInputStream("E:\\javacode\\src\\jing\\able\\Java\\IO\\输入流测试文件");
        return inputStream;
        */

        /* 第二种 : 从网络读
        Socket socket = new Socket("www.baidu.com",80);//域名加端口号
        OutputStream os = socket.getOutputStream();
        Writer writer = new OutputStreamWriter(os,"UTF-8");
        PrintWriter printWriter = new PrintWriter(writer,false);
        printWriter.printf("GET/HTTP/1.0\r\n\r\n");
        printWriter.flush();

        InputStream inputStream = socket.getInputStream();
        return inputStream;
         */

        /* 第三种：从内存上读
        byte[] bytes = "我是内存上的一段空间".getBytes("UTF-8");
        InputStream inputStream = new ByteArrayInputStream(bytes);
        return inputStream;
         */

        /*  第四种： 从标准输入读 （从键盘读入） 注意：需要手动输入  ctrl + D (或者ctrl + Z )才能终止键盘输入  */

          InputStream inputStream = System.in ;
          return inputStream;

    }