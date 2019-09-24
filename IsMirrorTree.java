public class IsMirrorTree{
//互为镜像
    Boolean isMirrorTree(Node p,Node q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && isMirrorTree(p.left,q.right)
                 		&& isMirrorTree(p.right,q.left);
    }
}
