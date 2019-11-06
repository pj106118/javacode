//寻找第K大
import java.util.*;

public class FinderKNumber {
    public int findKth(int[] a, int n, int K) {
        if( n == 0 || K > n){
            return -1;
        }
        Arrays.sort(a);
        return a[n-K];
    }
}