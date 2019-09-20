public class GetHeight{
static class Node{
        private char val;
        private Node left = null;
        private Node right = null;

        public Node(char val) {
            this.val = val;
        }
//求二叉树的高度(这只能用汇总)
    static int getHeight(Node root){
        if(root==null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left,right) + 1 ;
    }
}