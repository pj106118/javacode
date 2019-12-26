package jing.able.OJ;

/**
 * @author : panjing
 * @data : 2019/12/1 9:22
 * @describe :  输入一个字符串，求出该字符串包含的字符集合。
 * 
 */
import java.util.*;
public class StringTest {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                String str = in.nextLine();
                Map<Integer,Character> map = new HashMap<>();
                int index = 0;
                for(int i = 0;i<str.length();i++){
                    if(!map.containsValue(str.charAt(i))){
                        map.put(index,str.charAt(i));
                        index ++;
                    }
                }
                for (int i = 0; i < map.size(); i++) {
                    System.out.print(map.get(i));
                }
                System.out.println();
            }
            in.close();
        }
}
