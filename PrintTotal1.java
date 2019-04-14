package jing.able;

import java.util.Scanner;

/**
 * @author: panjing
 * @describe: 计算一个整数的各个位之和
 * @date: 2019/4/12
 * @time: 16:11
 */

public class PrintTotal {
    public static void main(String[] args) {
        System.out.println("请输入一个整数：");
        Scanner input = new Scanner (System.in);
        long num = input.nextInt();
        System.out.println(sumDigits(num));
    }

    public static int sumDigits(long num) {
        int sum = 0;
        while( num > 9 ){
            sum += num%10;
            num = num/10;
        }
        sum += num % 10;
        return sum;
    }
}
