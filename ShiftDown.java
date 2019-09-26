package jing.able.DS.heap;

import java.util.Arrays;

/**
 * @author : panjing
 * @data : 2019/9/22 11:16
 * @describe :   大根堆
 */
public class ShiftDown {
    public static void shiftDownBig( int[] array,int size,int index){
        int left = 2*index +1;

        while (left < size){
            int right = left +1;
            int max = left;
            if(array[left] <= array[right] && max+1 < size){
                max = right;
            }
            if(array[index] < array[max]){
                int tmp = array[index];
                array[index] = array[max];
                array[max] = tmp;
                index = max;
                left = 2*index +1;
            }else{
                break;
            }
        }
    }

}
