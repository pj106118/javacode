//斐波那契数列
public class FibonacciSequence {
    public int Fibonacci(int n) {
        int[] a =new int[40];
        a[0] = 0;
        a[1] = 1;
        for(int i = 2;i <= n;i++){
            a[i] = a[i-1] + a[i-2];
        }
        return a[n];
    }

 public int Fibonacci2(int n) {
        if(n<=1){
            return n;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}