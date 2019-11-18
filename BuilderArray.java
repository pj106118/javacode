//构建乘积数组
import java.util.ArrayList;
public class BuilderArray {
    public int[] multiply(int[] A) {
        int[] B = new  int[A.length];
        B[0] = 1;
        for(int i = 1;i<B.length;i++){
            B[i] = B[i-1] *A[i-1];
        }
        int tmp = 1;
        for(int j = B.length-1;j>=0;j--){
            B[j] *= tmp;
            tmp *= A[j] ;
        }
        return B;
    }
}