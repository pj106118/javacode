import java.util.Scanner;

public class ThreadDemo3 {
    private static class FibonacciThread2 extends Thread {
        private int n;
        FibonacciThread2(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            long result = Fibonacci.calc(n);
            System.out.printf("%nfib(%d) = %d%n", n, result);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入:");
            int n = scanner.nextInt();
            Thread thread = new FibonacciThread2(n);
            System.out.print("计算中 ");
            thread.start();
            while (thread.isAlive()) {
                Thread.sleep(1000);
                System.out.print(".");
            }
        }
    }
}
