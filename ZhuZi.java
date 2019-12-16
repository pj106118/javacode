package jing.able.OJ;

/**
 * @author : panjing
 * @data : 2019/12/1 10:17
 * @describe : 到底买不买
 * 小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖，
 * 于是小红要你帮忙判断一下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；
 * 如果不是，那么告诉她缺了多少珠子。为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。
 * 例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了全部她想要的珠子，还多了8颗不需要的珠子；
 * ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
 */

import java.util.*;
public class ZhuZi  {
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer,Character> map = new TreeMap<>();
        while (in.hasNext()) {
            String s = in.nextLine();
            String res = in.nextLine();
            int index =0;
            for(int i = 0;i<s.length();i++){
               map.put(index++,s.charAt(i));
            }
            boolean flag = true ;
            int count1 = 0;
            int count2 = 0;
            for(int j = 0;j<res.length();j++){
                if(map.containsValue(res.charAt(j))){
                    count1 ++;//多余的珠子
                }else{
                    flag = false;
                    count2++;
                }
            }
            if(flag){
                System.out.println("Yes" + " " + (s.length()-count1));
            }else{
                System.out.println("No"+ " "+ count2);
            }

        }
        in.close();
    }
    */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String s = in.nextLine();
            String res = in.nextLine();
            Map<Character,Integer> map = new HashMap<>();
            for(int i = 0;i<s.length();i++){
                int length = map.getOrDefault(s.charAt(i),0);
                map.put(s.charAt(i),length+1);
            }

            int count = 0;

            for(int j = 0;j< res.length();j++){
                int len = map.getOrDefault(res.charAt(j),0);
                if(len <= 0){
                    count ++;
                }
                map.put(res.charAt(j),len-1);
            }
            if(count == 0){
                System.out.println("Yes" +" " + (s.length()-res.length()));
            }else{
                System.out.println("No"+" " + count);
            }
        }
        in.close();
    }

}
