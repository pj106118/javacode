package jing.able.Java.OJ;

import java.util.Arrays;

/**
 * @author : panjing
 * @data : 2019/9/17 20:55
 * @describe : 根据一棵树的后序遍历与中序遍历构造二叉树。
 */
public class BuildTreeDemo2 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length==0){
            return null;
        }
        int rootVal = postorder[postorder.length-1];
        int postCount;
        for ( postCount = 0; postCount < inorder.length; postCount++) {
            if(inorder[postCount] == rootVal){
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);

        int[] leftInorder = Arrays.copyOfRange(inorder,0,postCount);
        int[] leftPostorder = Arrays.copyOfRange(postorder,0,postCount);
        root.left = buildTree(leftInorder,leftPostorder);

        int[] rightInorder = Arrays.copyOfRange(inorder,postCount+1,inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder,postCount,postorder.length-1);
        root.right = buildTree(rightInorder,rightPostorder);

        return root;
    }
}
