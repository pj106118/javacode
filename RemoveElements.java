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