package jing.able;

import java.util.Scanner;
public class GuessNumberOneTime {
    public static void main(String[] args){
        int number = (int)(Math.random() * 101);
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数字(0-100):");
        while (0<number  && number<100) {
            int choose = input.nextInt();
            if (choose == number) {
                System.out.println("Yes,You are right");
                break;
            } else if (choose > number) {
                System.out.println("You choose is too high");
            } else {
                System.out.println("You choose is too low");
            }
            System.out.println("请再次输入一个数字(0-100):");
        }
    }
}
