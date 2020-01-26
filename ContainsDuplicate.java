//给定一个整数数组，判断是否存在重复元素。
//如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
import java.util.*;
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
               return true; 
            }
            map.put(nums[i],1);
        }
        return false;
    }
}