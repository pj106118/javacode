package jing.able;
import java.util.*;
/**
 * @author: panjing
 * @describe:
 * @date: 2019/5/21
 * @time: 22:08
 */

public class SolveHuiwen {
        public static boolean isHuiwen(String s){
            int i =0;
            int j = s.length()-1;
            while(i<j){
                if(s.charAt(i)!=s.charAt(j)){
                    return false;
                }
                i ++;
                j--;
            }
            return true;
        }
        public static void main(String[] args){
            int count = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入字符串：");
            String str1 = sc.nextLine();
            System.out.println("请输入一个字符：");
            String str2 = sc.nextLine();
            for(int i = 0; i< str1.length();i++){
                StringBuilder s = new StringBuilder(str1);
                s.insert(i,str2);
                if( isHuiwen( s.toString() ) ){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
