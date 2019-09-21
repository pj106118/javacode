public class GetLeafSize{
//求叶子节点个数
static class Node{
        private char val;
        private Node left = null;
        private Node right = null;

        public Node(char val) {
            this.val = val;
        }
//求叶子节点个数第一种方法
    static int leafSize = 0;
    static void getLeafSize1(Node root){
        if (root==null){
            return;
        }
        if(root.right==null &&root.left==null){
            leafSize++;
        }
        getLeafSize1(root.right);
        getLeafSize1(root.left);
    }
    //求叶子节点个数第二种2方法
    static int getLeafSize2(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        int left = getLeafSize2(root.left);
        int right = getLeafSize2(root.right);
        return left+right;
    }
}