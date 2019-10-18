package jing.able.OJ;


import java.util.*;

/**
 * @author : panjing
 * @data : 2019/10/17 19:23
 * @describe :  子域名访问计数
 */
public class CommonMethod {

    //"900 google.mail.com"
    public static List<String> subdomainVisits(String[] cpdomains){
        Map<String,Integer> map = new HashMap<>();
        //用空格将900与域名分割
        for(String cpdomain : cpdomains){
            String[] a = cpdomain.split(" ");
            int n = Integer.valueOf(a[0]);
            String domain = a[1];
            //用.将域名分隔开
            String [] b = domain.split("\\.");
            for (int i = 0; i < b.length; i++) {
                String[] c = Arrays.copyOfRange(b,i,b.length);
                //join 拼接
                String subdomain = String.join(".",c);
                int oldCount  = map.getOrDefault(subdomain,0);
                map.put(subdomain,oldCount + n);
            }
        }

        List<String> ret = new ArrayList<>();
        for(Map.Entry<String,Integer> e: map.entrySet()){
            String domain  = e.getKey();
            int n = e.getValue();
            String s = String.format("%d %s",n,domain);
            ret.add(s);
        }
        return ret;
    }


    public static void main(String[] args) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(cpdomains).toString());
    }
}
