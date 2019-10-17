package jing.able.OJ;

import java.util.Stack;

/**
 * @author : panjing
 * @data : 2019/10/13 8:02
 * @describe :
 */
public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(popA.length == 0 || pushA.length == 0 || popA.length != pushA.length){
            return false;
        }
        int j = 0 ;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < pushA.length;i++){
            stack.push(pushA[i]);


            while(!stack.isEmpty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsPopOrder isPopOrder = new IsPopOrder();
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};

        System.out.println(isPopOrder.IsPopOrder(a,b));
    }
}
