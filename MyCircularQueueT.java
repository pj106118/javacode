class MyCircularQueue {

    int[] a;
    int front;
    int last;
    int size;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        a= new int[k];
        front = 0;
        last = 0;
        size = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size == a.length){
            return false;
        }
        a[last] = value;
        size++;
        last = (last +1)%a.length;    
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size == 0){
            return false;
        }
        
        size--;
        front = (front+1)%a.length;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(size==0){
            return -1;
        }
        return a[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(size==0){
            return -1;
        }
        
        return a[(last + a.length - 1)%a.length];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == a.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */