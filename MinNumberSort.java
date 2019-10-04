import java.util.*;
//把一个数组最开始的若干个元素搬到数组的末尾,我们称之为数组的旋转。,输入一个非递减非序的数组的一个旋转,输出旋转数组的最小元素。
public class MinNumberSort {
    public int minNumberInRotateArray1(int [] array) {
        if(array.length == 0){
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }
	public int minNumberInRotateArray2(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int min = array[0];
       for(int i = 0;i<array.length;i++){
           if(min > array[i]){
               int t = min;
               min = array[i];
               array[i] = t;
           }
       }
        return min;
    }
}