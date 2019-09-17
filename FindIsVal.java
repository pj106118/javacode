public class FindIsVal{

//判断是否存在val,存在返回true，否则返回false;
    boolean find2(Node root,int val){
        if(root == null){
            return false;
        }
        if(root.val == val){
            return true;
        }
        if (find2(root.left,val)){
            return true;
        }
        return find2(root.right,val);

    }
}