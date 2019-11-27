//Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，
//在Fibonacci数列中的数我们称为Fibonacci数。给你一 个N，
//你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，
//现在给你一个数N求最少需要多少步可以变为Fibonacci数。 
 
import java.util.*;
 
public class isFibonacciNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0;
        int num =0;
        while(num >= 0){
            if(Fibonacci(num) >= n){
                x = Fibonacci(num);
                break;
            }
            num++;
        }
        int y = Fibonacci(num-1);
        int result = (x-n)>(n-y)?(n-y):(x-n);
        System.out.println(result);
    }
    public static int Fibonacci(int n){
        if(n<=1){
            return n;
        }
        if(n==2){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
