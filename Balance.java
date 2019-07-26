import java.util.*; 
public class Balance {
	public boolean isBalance(TreeNode root) {
		//判断根元素是否为null
		if(root == null){
			return true; 
		}
		//获取左边子树高度
		int leftHeight = getTreeHeight(root.left);
		int rightHeight = getTreeHeight(root.right);
		//左右子树的高度大于1表示不是平衡二叉树
		if(Math.abs(leftHeight - rightHeight) > 1){
			return false;
		}
		//isBalance()检查是否平衡
		return isBalance(root.left) && isBalance(root.right);
	}
	//计算树的高度 
	public static int getTreeHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1; 
	} 
}
