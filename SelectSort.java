package jing.able;

/**
 * @author: panjing
 * @describe:  选择排序
 * @date: 2019/4/28
 * @time: 18:49
 */
//时间复杂度： O(n`2)
public class SelectSort {
    public static void selectSort(int[] array){
        for (int i = 0; i <array.length ; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
}
