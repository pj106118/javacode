//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
public class RotateArray {
    public void rotate(int[] nums, int k) {
       int [] n = new int[nums.length];
        for(int i =0;i<nums.length;i++){
          n[(i+k)%nums.length] = nums[i]; 
       } 
        for(int j =0;j<nums.length;j++){
            nums[j] = n[j];
        }
    }
}