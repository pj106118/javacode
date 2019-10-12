import java.util.*;
//输入某二叉树的前序遍历和中序遍历的结果,请 "重建出该二叉树。
//假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class RebuildTree {  
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 ){
            return null;
        }
        int k = pre[0];
        int index;
        for(index = 0;index < in.length;index++){
            if(in[index] == k){
                break;
            }
        }
        TreeNode root = new TreeNode(k);
        int[] leftpre = Arrays.copyOfRange(pre,1,1+index);
        int[] leftin = Arrays.copyOfRange(in,0,index);
        root.left = reConstructBinaryTree(leftpre,leftin);
        
        int[] rightpre = Arrays.copyOfRange(pre,1+index,pre.length);
        int[] rightin = Arrays.copyOfRange(in,1+index,in.length);
        root.right = reConstructBinaryTree(rightpre,rightin);
        
        return root;
    }
}