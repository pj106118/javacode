package jing.able.dao;

import jing.able.impl.IMyQueue;

/**
 * @author: panjing
 * @describe:  简单队列的实现
 * @date: 2019/4/14
 * @time: 15:38
 */

public class MyQueue implements IMyQueue {
    class Node{
        private Node next;
        private int data;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node front ;//代表队列的头
    private Node rear ;// 代表队列的尾
    private int usedSize;
    public MyQueue(){
        this.rear = null;
        this.front = null;
        this.usedSize = 0;
    }
    // 判断这个队列是否为空
    @Override
    public boolean empty() {
        return this.usedSize==0;
    }
    // 返回队首元素，但不出队列
    @Override
    public int peek() {
        if (empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }
    // 返回队首元素，并且出队列
    @Override
    public int poll() {
        if(empty()){
            throw new UnsupportedOperationException("队列为空");
        }
        int data = this.front.data;
        this.front=this.front.next;
        this.usedSize--;
        return data;
    }
    // 将 item 放入队列中
    @Override
    public void add(int item) {
        Node node = new Node(item);
        if(empty()){
            this.front = node;
            this.rear = node;
        }else{
            this.rear.next = node; //尾插
            this.rear = this.rear.next;
        }
        this.usedSize++;
    }
    // 返回元素个数
    @Override
    public int size() {
        return this.usedSize;
    }
}
