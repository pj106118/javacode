public class GetKLevel{
//求 第k层的节点个数
    public static int getKLevel(Node root,int k){
        if(root==null){
            return 0;
        }
        if (k==1 && root!=null){
            return 1;
        }
        return getKLevel(root.left,k-1)+getKLevel(root.right,k-1);
    }
}