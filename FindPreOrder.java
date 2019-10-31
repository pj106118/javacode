//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
//如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
public class FindPreOrder {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return preOrder(sequence,0,sequence.length-1);
    }
    public boolean preOrder(int[] a,int start,int end){
        if(start>=end){
            return true;
        }
        int i = start;
        for(;i<end;i++){
            if(a[i]>a[end]){
                break;
            }
        }
        
        for(int j = i;j<end;j++){
            if(a[j]<a[end]){
                return false;
            }
        }
        return preOrder(a,start,i-1)&&preOrder(a,i,end-1);
        
    }
}