package jing.able;

/**
 * @author: panjing
 * @describe: 循环队列
 * @date: 2019/4/21
 * @time: 14:43
 */

public class MyCircularQueue {
    private int front; //队头
    private int rear;  //队尾
    private int[] elem; //数组
    private int usedSize; //有效数据个数
    public MyCircularQueue(int k){
        this.elem = new int[k];
        this.front = 0;
        this.rear = 0;
        this.usedSize= 0;
    }
    //入队
    //(rear + 1)% length  判断循环队列满的方法
    public boolean enQueue(int value) {
      if(isFull()){
          return false;
      }
      this.elem[this.rear] = value;
      rear = (rear+1) % this.elem.length;
      this.usedSize++;
      return true;
    }
    //出队
    public boolean deQueue() {
        if (isFull()){
            return false;
        }
        this.front = (front +1) % this.elem.length;
        this.usedSize--;
        return true;
    }
    //得到队头元素
    public int Front() {
        if (isFull()){
            throw new  UnsupportedOperationException("队为空");
        }
        return this.elem[this.front];
    }
    //得到队尾元素
    public int Rear() {
        if (isFull()){
            throw new  UnsupportedOperationException("队为空");
        }
       if (this.rear != 0){
           return this.elem[this.rear-1];
       }else{
           return this.elem[this.elem.length-1];
       }
    }
    //是否为空
    public boolean isEmpty() {
        return this.front == this.rear;
    }
    //是否为满
    public boolean isFull() {
        if ((this.rear + 1) % this.elem.length == this.front){
            return true;
        }else{
            return false;
        }
    }
}
