public class GetSize{
	 private static int count = 0;
	static class Node{
        private char val;
        private Node left = null;
        private Node right = null;

        public Node(char val) {
            this.val = val;
        }
//节点个数  这种方法每次调用时必须要清空count的值
    private static void getSize1(Node root) {
        if (root==null){
            return ;
        }
        count++;
        getSize(root.left);
        getSize(root.right);
    }
    //个数求法2,一个汇总过程，不用再定义临时变量
    private static int getSize2(Node root) {
        if (root == null) {
            return 0;
        }
        int left = getSize2(root.left);
        int right = getSize2(root.right);
        return left+right+1;
    }
}