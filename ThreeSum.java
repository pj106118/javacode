package jing.able.Java.OJ;

import java.util.*;


/**
 * @author : panjing
 * @data : 2019/9/12 18:34
 * @describe :   求三数和为零
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,1,4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums){
        Set<List<Integer>> lead = new HashSet<>();

        Arrays.sort(nums);   //排序
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j =i + 1; j < nums.length-1; j++) {
                for (int k = nums.length-1; k > j; k--) {
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> e = new ArrayList<>();
                        e.add(nums[i]);
                        e.add(nums[j]);
                        e.add(nums[k]);
                        lead.add(e);
                    }
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(lead);
        return list;
    }
}
