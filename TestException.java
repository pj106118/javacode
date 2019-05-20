package jing.able;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author: panjing
 * @describe: 提示用户读取两个整数，然后显示他们的和，
 * 程序应该在输入不正确的时提示用户再一次读取数据
 * @date: 2019/5/19
 * @time: 12:28
 */

public class TestException {
    public static void main(String[] args) {
        boolean flag = true;
        do {
            try {
                System.out.println("请输入两个整数：");
                Scanner scanner = new Scanner(System.in);
                int sum = scanner.nextInt() + scanner.nextInt();
                System.out.println("您输入的整数和为： " + sum);
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("输入格式错误！");
            }
        }while(flag);
    }
}