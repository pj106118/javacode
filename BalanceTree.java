//平衡二叉树的检查
import java.util.*;

 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class BalanceTree {
    public boolean isBalance(TreeNode root) {
        if(root ==null){
            return true;
        }
        if(!isBalance(root.left) || !isBalance(root.right)){
            return false;
        }
        
        int left = hight(root.left);
        int right = hight(root.right);
        if(left - right <= 1 && left - right >= -1 ){
            return true;
        }
        return false;
    }
    public int hight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = hight(root.left);
        int right = hight(root.right);
        return Math.max(left,right) +1;
    }
}