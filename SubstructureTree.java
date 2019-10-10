//输入两棵二叉树A，B，判断B是不是A的子结构。
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class SubstructureTree {
    public boolean HasSubtree(TreeNode p,TreeNode q) {
       if(p == null || q==null){
           return false;
       }
        return sameTree(p,q) 
            || sameTree(p.left,q)
            || sameTree(p.right,q);
    }
    public boolean sameTree(TreeNode p,TreeNode q){
         if(q==null){
            return true;
        }
        if(p == null){
           return false;
       }
       
        if(p.val != q.val){
            return   sameTree(p.left,q)
                || sameTree(p.right,q);
        }
        return  sameTree(p.left,q.left)
            && sameTree(p.right,q.right);
    }
}