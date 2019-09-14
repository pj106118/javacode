package jing.able.Java.OJ;

import java.util.Stack;

/**
 * @author : panjing
 * @data : 2019/9/12 20:29
 * @describe :   用两个队列实现栈
 */
public class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public int pop(){
        if(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        if (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
    public void push(int node){
        stack1.push(node);
    }

}
