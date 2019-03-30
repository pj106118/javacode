package jing.able;
import java.util.Scanner;
    public class TestCode {

        public static boolean isPrime(int number) {
            int j;
            boolean isprime=true;
            for(j=2;j<number;j++)
            {
                if(number%j==0||number==1) {
                    isprime=false;
                }
            }
            return isprime;
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入一个数");
            int i=input.nextInt();
            System.out.print(isPrime(i));
        }
    }
