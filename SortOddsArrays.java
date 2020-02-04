/*
给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素(按升序的方式)。
*/
class SortOddsArrays {
    public int[] sortArrayByParity(int[] A) {
        Arrays.sort(A);
        int [] a = new int[A.length];
        int right = A.length-1;
        int left = 0;
        while(left <= right){
            for(int i = 0;i<A.length;i++){
                if(A[i] %2==0){
                    a[left++] = A[i];
                }else{
                    a[right--] = A[i];
                }
            }
        }
        return a;
    }
}