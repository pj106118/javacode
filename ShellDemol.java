package jing.able;

/**
 * @author: panjing
 * @describe:   希尔排序
 * @date: 2019/4/21
 * @time: 16:53
 */

public class ShellDemol {
    public static void shell (int[] array,int gap) {
        int tmp = 0;
        int i = gap;
        int j = i - gap;
        for (i = gap; i < array.length; i++) {
            tmp = array[i];
            for (j = i - gap; j >= 0; j = j - gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }
    public static void shellSort(int[] array){
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length ; i++) {
            shell(array,drr[i]);
        }
    }
}
