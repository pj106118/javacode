public class URLdemo {
	//对一个给定的URL进行解码
    public static void main(String[] args) {
        String url = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=c" +
                "%2B%2B&rsv_pq=a4fc69f200076536&rsv_t=2b96NbhzR2Ir" +
                "%2BdW1z0tx0yYZJG0xZgadx7dwH0Qkvn6IH793SOANRIZNaj0" +
                "&rqlang=cn&rsv_enter=1&rsv_dl=tb&rsv_sug3=3&rsv_sug1=3" +
                "&rsv_sug7=100&rsv_sug2=0&prefixsug=c%252B%252B&rsp=2&inputT=1160&rsv_sug4=1161\n";
        String[] s1 = url.split("://");
        System.out.println("协议方案名称："+s1[0]);
        String[] s2 = s1[1].split("/");
        System.out.println("地址为："+s2[0]);
        if(s1[0].equals("https")){
            System.out.println("端口号为："+443);
        }else if(s1[0].equals("http")){
            System.out.println("端口号为："+80);
        }else if(s1[0].equals("jdbc:mysql")){
            System.out.println("端口号为："+3306);
        }

        String[] s3 = s2[1].split("\\?");
        System.out.println("文件路径为："+s3[0]);

        if(s3[1].contains("#")){
            String[] s4 = s3[1].split("#");
            System.out.println("查询字符串为："+s4[0]);
            System.out.println(s4[1].toString());
        }else{
            System.out.println(s3[1].toString());
        }

    }
}
