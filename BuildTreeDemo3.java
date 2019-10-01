package jing.able.Java.OJ;

import java.util.List;

/**
 * @author : panjing
 * @data : 2019/9/19 18:45
 * @describe :  只用前序序列和空节点构造二叉树
 */
public class BuildTreeDemo3 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private static class BTRV {
        private TreeNode root;
        private int used;
    }
    BTRV buildTree5(List<Integer> preorder) {
        BTRV returnValue = new BTRV();
        if (preorder.size() == 0) {
            returnValue.root = null;
            returnValue.used = 0;
            return returnValue;
        }
        int rootValue = preorder.get(0);
        if (rootValue == '#') {
            returnValue.root = null;
            returnValue.used = 1;
            return returnValue;
        }
        BTRV leftReturn = buildTree5(preorder.subList(1, preorder.size()));
        BTRV rightReturn = buildTree5(preorder.subList(1 + leftReturn.used,
                preorder.size()));
        TreeNode root = new TreeNode(rootValue);
        root.left = leftReturn.root;
        root.right = rightReturn.root;
        returnValue.root = root;
        returnValue.used = 1 + leftReturn.used + rightReturn.used;
        return returnValue;
    }
}

