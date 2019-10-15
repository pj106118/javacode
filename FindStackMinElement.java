import java.util.Stack;
//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
public class FindStackMinElement {

    Stack<Integer> stack = new Stack<Integer>();
    Integer minElement = Integer.MAX_VALUE;
    
    public void push(int node) {
        if(stack.isEmpty()){
            stack.push(node);
            minElement = node;
        }else {
            if(node < minElement){
            stack.push(minElement);
            minElement = node;
        }
            stack.push(node); 
    }
   }
   
    public void pop() {
        if(stack.size() == 0){
            return;
        }
        if(stack.peek() == minElement){
            if(stack.size() > 1){
                stack.pop();
                minElement = stack.peek();
            }else{
                minElement = Integer.MAX_VALUE;
            }
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return minElement;
    }
}