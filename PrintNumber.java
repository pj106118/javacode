package jing.able;
import java.util.Scanner;
/**
 * @author: panjing
 * @describe:  编写动态规划求组和数
 * @date: 2019/4/8
 * @time: 19:40
 */
public class PrintNumber {
        // 求排列数 A(n,m) n>m
        public static int A(int n, int m) {
            int result = 1;    // 循环m次,如A(6,2)需要循环2次，6*5
            for (int i = m; i > 0; i--) {
                result *= n;
                n--;        // 下一次减一
            }
            return result;
        }
        public static int C2(int n, int m){
            // int denominator=factorial(up);//分母up的阶乘
            //分母
            int denominator = A(m, m);   // A(6,6)就是求6的阶乘
            // 分子
            int numerator = A(n, m);// 分子的排列数
            return  numerator / denominator;
        }
        public static int C(int n, int m) {
            int helf = n / 2;
            if (m > helf) {
                m = n - m;
            }
            // 分子的排列数
            int numerator = A(n, m);
            // 分母的排列数
            int denominator = A(m, m);
            return numerator / denominator;
        }
        public static void main(String[] args) {
            System.out.println("请输入组合数的数字：");
            Scanner input = new Scanner(System.in);
            int len = input.nextInt();
            for (int i = 1; i <= len; i++) {
                System.out.println("A("+len+"," + i + ")=" + A(len, i));
            }
            for (int i = 1; i <= len; i++) {
                System.out.println("C("+ len+"," + i + ")=" + C(len, i));
            }
        }
    }
