package jing.able;

/**
  数字之和
 */
import java.util.Scanner;

public class AddTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int a = add(num);
            int b = add(num*num);
            System.out.println(a +" " + b);
        }
        sc.close();
    }
    public static int add(int num){
        int count = 0;
        while(num!=0){
            count += num % 10; //余数
            num /= 10;
        }
        return count;
    }


}