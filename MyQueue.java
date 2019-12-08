public class MyQueue {
	//生产者消费者模型的简单实现
    private int[] array = new int[10];
    private int size = 0;
    private int front = 0;
    private int rear = 0;

    private Object empty = new Object();
    private Object full = new Object();

    public  void put(int message) throws InterruptedException {
        do {
            while (size == array.length) {
                synchronized (full) {
                    full.wait();
                }
            }
            synchronized (this) {
                if(size == array.length){
                    continue;
                }
                array[rear] = message;
                rear = (rear + 1) % array.length;
                size++;
            }
                synchronized (empty) {
                    empty.notify();
                }
                return ;
        }while(true);
    }

    public synchronized int take() throws InterruptedException {
        do{
        if(size == 0){
            synchronized(empty){
                empty.wait();
            }
        }
            int message;
        synchronized (this) {
            if(size == 0){
                continue;
            }
            message = array[front];
            front = (front + 1) % array.length;
            size--;
        }
        synchronized (full) {
            full.notify();
        }
            return message;
        }while(true);
        
    }
}
