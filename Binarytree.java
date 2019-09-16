//二叉树的前中后序遍历(深度遍历)
public class BinarytreeTest {
    private static int count = 0;
    static class Node{
        private char val;
        private Node left = null;
        private Node right = null;

        public Node(char val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format("{%c}",val);
        }
    }
	//建立二叉树
    public static Node buildTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left=b;a.right = c;
        b.left =d;b.right = e;
        e.right = h;
        c.left = f;c.right=g;

        return a;
    }
    //前序遍历
    public static void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.println(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }
    //中序遍历
    public static void inOrderTraversal(Node root){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root);
        inOrderTraversal(root.right);
    }
    //后序遍历
    public static void postOrderTraversal(Node root){
        if(root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root);
    }