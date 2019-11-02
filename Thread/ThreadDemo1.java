public class ThreadDemo1 {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("我在 method2 中打印");
                // 进程会暂停运行 1 秒
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void method2() {
        Thread thread = new MyThread();
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException {
        method2();
        while (true) {
            System.out.println("我在 main 中打印");
            // 进程会暂停运行 1 秒
            Thread.sleep(1000);
        }
    }

    private static void method1() throws InterruptedException {
        while (true) {
            System.out.println("我在 method1 中打印");
            // 进程会暂停运行 1 秒
            Thread.sleep(1000);
        }
    }
}
