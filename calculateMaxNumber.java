import java.util.*;
//从第0个开始最大的连续子向量的和
public class calculateMaxNumber {
    public int FindGreatestSumOfSubArray(int[] array) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,array[0]);
        int max = array[0];
        for(int i = 1 ;i<array.length;i++){
           map.put(i,(map.get(i-1))+array[i]);
            if(max<map.get(i)){
                max = map.get(i);
            }
        }
        return max;
    }
}