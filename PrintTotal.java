package jing.able;
import java.util.Scanner;
public class PrintTotal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        Long num = scanner.nextLong();
        System.out.print(num + "的各位数字之和为：" + sumDigits(num));
    }
    public static int sumDigits(long n) {
        int sumTotal = 0;
        char ch;
        String str = String.valueOf(n).toString();
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            sumTotal = sumTotal + Integer.parseInt(String.valueOf(ch));
        }
        return sumTotal;
    }


}
