package jing.able.dao;

import jing.able.impl.IMyStack;

/**
 * @author: panjing
 * @describe:   简单栈的实现
 * @date: 2019/4/14
 * @time: 15:08
 */

public class MyStack implements IMyStack {
    private int[] elem;
    private int top; //保存得是当前可以存放数据源数的下标
    private int usedSize;
    //默认栈的容量
    private static final int DEFAULT_SIZE=10;  //栈的长度
    public MyStack(){
        this.elem = new int[DEFAULT_SIZE];
        this.top = 0;
        this.usedSize = 0;
    }

    public boolean isFull(){
        return this.top== this.elem.length;
    }
    @Override
    public void push(int item) {
        if(isFull()) {
          throw new UnsupportedOperationException("栈为满");
        }
        this.elem[this.top++] =item;
    }

    @Override
    public int pop() {
       if (empty()){
           throw new UnsupportedOperationException("栈为空");
       }
       int data = this.elem[this.top-1];
       this.usedSize--;
       this.top--;
       return data;
    }

    @Override
    public int peek() {
        if (empty()){
            throw new UnsupportedOperationException("栈为空");
        }
        return this.elem[this.top-1];
    }

    @Override
    public boolean empty() {
        if (this.top == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.usedSize;
    }
}
