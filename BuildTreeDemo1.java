package jing.able.Java.OJ;

import java.util.Arrays;

/**
 * @author : panjing
 * @data : 2019/9/17 19:50
 * @describe :  根据一棵树的前序遍历与中序遍历构造二叉树。
 */
public class BuildTreeDemo1 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        int rootVal = preorder[0];
        int leftCount;
        for (leftCount = 0; leftCount < preorder.length; leftCount++) {
            if(preorder[leftCount] == rootVal){
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        //左子树的前序和中序
        int[] leftPreorder = Arrays.copyOfRange(preorder,1,1+leftCount);
        int[] leftInorder = Arrays.copyOfRange(inorder,0,leftCount);
        root.left = buildTree(leftPreorder,leftInorder);

        //右子树的前序和中序
        int[] rightPreorder = Arrays.copyOfRange(preorder,1+leftCount,preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder,1+leftCount,preorder.length);
        root.left = buildTree(rightPreorder,rightInorder);

        return root;
    }
}
