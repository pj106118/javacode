//有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。请设计
//一个高效的算法，计算给定数组中的逆序对个数。
import java.util.*;

public class AntiOrder {
    public int count(int[] A, int n) {
        int count = 0;
        for(int i = 0;i< n-1 ;i++){
            for(int j = i+1;j<n;j++){
                if(A[i]>A[j]){
                    count++;
                }
            }
        }
        return count;
    }
}