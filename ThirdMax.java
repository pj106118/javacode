/*
给定一个非空数组，返回此数组中第三大的数。
如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
*/
import java.util.*;
class ThirdMax {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num:nums){
            set.add(num);
        }
        if(set.size()<3){
            return set.last();
        }else{
            set.remove(set.last());
            set.remove(set.last());
             return set.last();
        }
       
    }
}