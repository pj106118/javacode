/*
给定一个整数数组 nums 和一个目标值 target，
请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
*/
class SumOfTwoNumbers {
    public int[] twoSum(int[] nums, int target) {
       for(int i =0;i<nums.length;i++){
           for(int j =i+1;j<nums.length;j++){
               if(nums[j] == target-nums[i]){
                   return new int[]{i,j};
               }
            }
       }
        return null;
    }
}