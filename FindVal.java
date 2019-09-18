public class FindVal{
//查找val所在节点，没有找到返回null
    // 按照根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find1(Node root,int val){
        if (root == null){
            return null;
        }
        if (root.val == val ){
            return root;
        }
        Node left = find1(root.left,val);
        if (left != null){   //只有两种情况，一种是找到了，那么left中放进去的是val的节点
                            // 另一种就是没找到，那么left中放进去的就是null
            return left;
        }
        Node right = find1(root.right,val);
        if (right != null){
            return right;
        }
         return null;
    }
}