package jing.able.Java.OJ;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : panjing
 * @data : 2019/9/19 19:06
 * @describe :  二叉树遍历  例：534##7##1##
 */
public class BinaryTreeTest {

    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    private static class BTRV {
        private TreeNode root;
        private int used;

        public BTRV(TreeNode root, int used) {
            this.root = root;
            this.used = used;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();  //读入
        char[] chars = result.toCharArray();
        BTRV btrv = buildTree(chars);
        inorder(btrv.root);
    }
    static BTRV buildTree(char[] chars) {
        if(chars[0] == '#'){
            return new BTRV(null,1);
        }
        if(chars.length == 0){
            return new BTRV(null,0);
        }

        TreeNode root = new TreeNode(chars[0]);
        BTRV left = buildTree(Arrays.copyOfRange(chars,1,chars.length));
        BTRV right = buildTree(Arrays.copyOfRange(chars,left.used+1,chars.length));

        root.left = left.root;
        root.right = right.root;

        return new BTRV(root,1 + left.used + right.used);
    }
    public static void inorder(TreeNode root){
        if(root != null){
             inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }
}
