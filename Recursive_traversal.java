package jing.able.Java.OJ;

import java.util.Stack;

/**
  非递归遍历二叉树
 */
public class Recursive_traversal {

    class Node {
        int val;
        Node left;
        Node right;
    }

    //前序
    public static void preOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    }

    //中序
    public static void inOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {

                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.println(top.val);
            cur = top.right;
        }
    }
    //后序
    public static void postOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur !=null){
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.peek();
            Node last = null;
            if(top.right == null || top.right == last){
                System.out.println(top.val);
                stack.pop();
                last = top;
            }else{
                cur = top.right;
            }
        }
    }
}
