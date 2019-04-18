package jing.able;
import java.util.HashMap;
import java.util.Stack;
/**
 * @author: panjing
 * @describe: 括号匹配问题
 * @date: 2019/4/14
 * @time: 16:38
 */

public class PrintKuoHao {


    class Solution {
        //定义一个负责匹配括号（即映射，一一对应）的哈希表
        private HashMap<Character, Character> mappings;
       //对匹配括号的哈希表进行初始化
        public Solution() {
            this.mappings = new HashMap<Character, Character>();
            this.mappings.put(')', '(');
            this.mappings.put('}', '{');
            this.mappings.put(']', '[');
        }

        public boolean isValid(String s) {
            // 初始化要在算法中使用的堆栈
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);   //将s的第i个元素的指向的位置的字符值传递给字符c
                if (this.mappings.containsKey(c)) {    // 如果传给c的字符是右括号类型的字符

                    char topElement = stack.empty() ? '￥' : stack.pop(); // 获取栈顶元素，如果栈为空，返回￥，否则返回栈顶元素

                    // 如果用get（）方法获取得到的字符与栈顶元素不匹配，返回false
                    if (topElement != this.mappings.get(c)) {
                        return false;
                    }
                } else {
                    // 如果是左括号的字符就进栈
                    stack.push(c);
                }
            }

            // 如果栈中还有剩余的字符，就返回false
            return stack.isEmpty();
        }
    }
}
