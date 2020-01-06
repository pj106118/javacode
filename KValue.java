
//给定一棵二叉搜索树，请找出其中的第k小的结点。
//例如,（5，3，7，2，4，6,8)中，按结点数值大小顺序第三小结点的值为4。
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.*;
public class KValue {
    TreeNode KthNode(TreeNode pRoot, int k){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        
        if(pRoot == null || k <= 0){
            return null;
        }
        TreeNode cur = pRoot;
        while(cur!=null || !stack.isEmpty()){
            while(cur != null ){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node);
            cur = node.right;
            
        }
        if(k > list.size()){
            return null;
        }
        return list.get(k-1);
    }

}