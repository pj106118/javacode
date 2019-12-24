//从字节流中最终获得字符数据的三种方式
public static String resultInputStrem(InputStream is) throws IOException {
        /* 第一种
        byte[] buffer = new byte[1024];
        int len  = is.read(buffer);
        String message = new String(buffer,0,len,"UTF-8");
        return message;
        */

        /* 第二种 2.1
        Reader reader = new InputStreamReader(is,"UTF-8");
        char[] buffer = new char[1024];
        int len  = reader.read(buffer);
        String message = new String(buffer,0,len);
        return message;
        */

        /*  第二种  2.2
        StringBuilder sb = new StringBuilder();
        Reader reader = new InputStreamReader(is,"UTF-8");
        char[] buffer = new char[1024];
        int len ;
        while((len = reader.read(buffer))!=-1){
            sb.append(buffer,0,len);
        }
        String message = sb.toString();
        return message;
        */

        /*  用bufferedReader */

        /*  第三种
        Reader reader = new InputStreamReader(is,"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer();
        String line;
        while((line = bufferedReader.readLine()) != null){
            sb.append(line);
        }
        String message = sb.toString();
        return message;
        */
        //第四种
        Scanner scanner = new Scanner(is, "UTF-8");
        return scanner.nextLine();
    }