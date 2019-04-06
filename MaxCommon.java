package jing.able;

/**
 * @author panjing
 * @describe:求最大公约数
 * @date 2019/4/6
 * @time 22:28
 */

import java.util.Scanner;

public class MaxCommon {
    public static void main(String[] args) {
        System.out.println("请输入一个整数：");
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        System.out.println("请输入一个整数：");
        int num2 = input.nextInt();
        int result = 1;
        int i = 2;
        while (i<=num1 && i<=num2){
            if (num1%i==0 && num2%i==0)
                result = i;
            i++;
        }
        System.out.println(num1 + "和" +num2 + "的最大公约数为："+ result );
    }
}
