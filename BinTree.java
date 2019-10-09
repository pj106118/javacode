package jing.able.DS.BinTree;

/**
 * @author : panjing
 * @data : 2019/10/8 18:47
 * @describe : 二叉搜索树
 */
public class BinTree {
    class Node{
        Node left;
        Node right;
        int key;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return  key +"";
        }
    }
    Node root = null;

    /**
     * 搜索
     * @param key
     * @return   返回与key相同的节点，否则返回空
     */
    public Node seach(int key){
        Node cur = root;
        while(cur != null){
            if(cur.key == key){
                return cur;
            }else if(key < cur.key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return null;
    }
    /**
     * 插入
     * @param key
     * @return  true 表示插入成功
     */
    public boolean insert(int key) {
        Node node = new Node(key);
        Node cur = root;
        Node parent = null;
        if(root == null){
            root = node ;
            return true;
        }

        while(cur != null){
            if(cur.key == key){
                return false;
            }else if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        //没找到

        if(key < parent.key){
             parent.left = node;
        }else {
             parent.right = node ;
        }

       return true;
    }

    public static void main(String[] args) {
        BinTree binTree = new BinTree();

        int[] a = {5,2,3,6,8,4,1,7,9,0};
        for (int i : a) {
            System.out.println(binTree.insert(i));
        }
        System.out.println("前序遍历：");
        preOrder(binTree.root);
        System.out.println();
        System.out.println("中序遍历：");
        inOrder(binTree.root);
        System.out.println();
        System.out.println("=================");
        System.out.println("插入重复数据：");
        System.out.println(binTree.insert(4));
        System.out.println("查找数据：");
        System.out.println(binTree.seach(5));
        System.out.println(binTree.seach(11));

    }

    private static void inOrder(Node root) {
        if(root != null){

            inOrder(root.left);
            System.out.print(root + " ");
            inOrder(root.right);
        }
    }

    private static void preOrder(Node root) {
        if(root != null){
            System.out.print(root + " ");
            preOrder(root.left);

            preOrder(root.right);
        }
    }
}
