package jing.able.Java.OJ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : panjing
 * @data : 2019/9/19 21:10
 * @describe :   判断是否为完全二叉树
 */
public class LeverlOrder2 {
    static class Node{
        int val;
        Node root;
        Node left;
        Node right;

        public Node(int val, Node root) {
            this.val = val;
            this.root = root;
        }
        public static boolean LeverlOrder1(Node root){
            boolean flag = false;
            if(root == null){
                return true;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while(true){
                Node front = queue.poll();
                if(front == null){
                    break;
                }
                queue.offer(front.left);
                queue.offer(front.right);
            }
            while(!queue.isEmpty()){
                Node n = queue.poll();
                if(n != null){
                    return false;
                }
            }
            return true;
        }
    }
}
