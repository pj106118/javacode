package jing.able;

/**
 * @author: panjing
 * @describe: 求出小于10000的素数的个数
 * @date: 2019/4/12
 * @time: 16:27
 */

public class PrintPrimeNumber {
    public static void main(String[] args) {

        int tatal =  printPrimeNumber();
        System.out.println("小于10000的素数的个数为："+ tatal);
    }

    public static int printPrimeNumber() {
        int count = 0;
        int number = 2;
        while (number < 10000) {
            if (isprime(number)) {
                count++;

            }
            number++;
        }
        return count;
    }

    public static boolean isprime(int number) {
        for (int i = 2; i <= number/2; i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
