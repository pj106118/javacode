package jing.able.Java;



/**
 * @author : panjing
 * @data : 2019/11/17 14:50
 * @describe :  输出m到n之间合数的个数
 */
import java.util.Scanner;
public class PrintSomeNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        int max = m>n?m:n;
        int min = m>n?n:m;
        int count = 0;
        for (int i = min; i <= max; i++) {
            if(!prime(i) && i % 2 != 0){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean prime(int n) {

        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;

        } else {
            int a = (int) Math.sqrt(n);
            for (int i = 2; i <= a; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
