package jing.able;

/**
 * @author: panjing
 * @describe: 直接插入排序
 * @date: 2019/4/21
 * @time: 15:45
 */
//时间复杂度 n*n
//如果给定的是有序的数据，那么时间复杂度为O(n)
//稳定性： 稳定
public class Demol {
    public static void intsertSort(int[] array) {
        int tmp = 0;
        int i = 1;
        int j = i-1;
        for (i = 1; i < array.length; i++) {
            tmp = array[i];
            for ( j = i-1; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
}
