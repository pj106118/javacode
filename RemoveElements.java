//给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
class RemoveElements {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int size = nums.length;
        int index = nums.length-1;
        for(int i = 0;i<nums.length;i++){
            while(nums[i]==val && index >= i){
                size--;
                swap(nums,i,index);
                index--;
            }
        }
        return size;
    }
    public void swap(int a[],int x,int y){
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}