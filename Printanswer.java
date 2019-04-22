package jing.able;
/**
 * @author: panjing
 * @describe: 括号匹配问题
 * @date: 2019/4/14
 * @time: 16:38
 */

public class Printanswer {
    class Solution {
           public boolean  isValid(String str) {
                char[] stack = new char[str.length()];
                int top = 0;
                for (int i = 0; i <str.length() ; i++) {
                if(str.charAt(i) == '(' || str.charAt(i) == '['||str.charAt(i) == '{'){
                    stack[top++] = str.charAt(i);
                }else{
                    if (top == 0){
                        System.out.println("右括号多");
                        return false;
                    }
                    char ch = stack[top-1];
                    if (ch == '(' && str.charAt(i)==')'||ch == '[' && str.charAt(i)==']'
                            ||ch == '{' && str.charAt(i)=='}'){
                        top--;
                    }else{
                        System.out.println("右括号匹配的顺序不一致");
                        return false;
                    }
                }
            }
            if (top>0){
                System.out.println("左括号多余右括号");
                return false;
            }
            System.out.println("左右匹配");
            return true;
        }
    }
}
