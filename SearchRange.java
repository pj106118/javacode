/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。
找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值，返回 [-1, -1]。
*/
class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        for(int i =0;i<nums.length;i++){
            if(nums[i] == target ){
                if(start == -1){
                    start = i;
                }else{
                    end = i;
                }
            }
        }
        if(end==-1 && start != -1){
            end = start;
        }
        return new int[]{start,end};
        
    }
}