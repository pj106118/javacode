package jing.able.Java;

/**
 * @author : panjing
 * @data : 2019/11/17 14:28
 * @describe :    1到n平方数的个数
 */
import java.util.*;
public class SquareNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int result = count(n);
            if(result== -1){
                continue;
            }else {
                System.out.println(result);
            }
        }
    }

    private static int count(int n) {
        if(n > 100000){
            return -1;
        }
        int count  = 0;
        for(int i = 1;i< Math.sqrt(n);i++){
            if(i*i <= n){
                count ++;
            }
        }
        return count ;
    }

}
