public class ThreadDemo4 {
    private static final long COUNT = 10_0000;

    public static void main(String[] args) throws InterruptedException {
        serial();     // 串行
        concurrent();   // 并发
    }

    private static class CalcThread extends Thread {
        @Override
        public void run() {
            int n = 0;
            for (long i = 0; i < COUNT; i++) {
                n++;
            }
        }
    }

    private static void concurrent() throws InterruptedException {
        long begin = System.nanoTime();

        Thread thread1 = new CalcThread();
        thread1.start();
        Thread thread2 = new CalcThread();
        thread2.start();

        int a = 0;
        for (long i = 0; i < COUNT; i++) {
            a++;
        }

        thread1.join();
        thread2.join();

        long end = System.nanoTime();
        double s = (end - begin) * 1.0 / 1000 / 1000 / 1000;
        System.out.printf("并发模式: 耗时: %.4f%n", s);
    }

    private static void serial() {
        long begin = System.nanoTime();

        int a = 0;
        for (long i = 0; i < COUNT; i++) {
            a++;
        }
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b++;
        }
        int c = 0;
        for (long i = 0; i < COUNT; i++) {
            c++;
        }

        long end = System.nanoTime();
        double s = (end - begin) * 1.0 / 1000 / 1000 / 1000;
        System.out.printf("串行模式: 耗时: %.4f%n", s);
    }
}
