package jing.able;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: panjing
 * @describe:
 * @date: 2019/6/4
 * @time: 19:21
 */

public class LockTest {
    public static void main(String[] args) {
        Task task =new Task(); //创建真实线程类
        Thread thread0 = new Thread(task,"买票人1");
        Thread thread1 = new Thread(task,"买票人2");
        Thread thread2 = new Thread(task,"买票人3");
        thread0.start();
        thread1.start();
        thread2.start();
    }
}
class Task implements Runnable{
    private int ticket = 200;
    private Lock ticketLock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            try {
                ticketLock.lock();//加锁
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"票");
                }
            }finally{
                ticketLock.unlock();//解锁
            }
        }
    }
}