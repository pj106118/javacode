package jing.able.Java.OJ;


import java.util.Arrays;

/**
 * @author : panjing
 * @data : 2019/9/14 11:41
 * @describe :  交换一次排列
 */
public class ExchangeQueue {

    public static void main(String[] args) {
        int[] A = {3,1,1,3};
        int[] b =prevPermOpt1(A);
        System.out.println(Arrays.toString(b));
    }

    public static int[] prevPermOpt1(int[] A) {
        Boolean flag1 = true;
        Boolean flag2 = true;
        int index = 0;
        int max_index = 0;
        //数组内的数据是升序的
        for (int i = 0; i < A.length-1; i++) {
            if(A[i] <= A[i+1]){
                flag1 = false;
            }else {
                flag1 = true;
                break;
            }
        }
        if (!flag1){
            return A;
        }
        //数组内的数据是降序的,交换最后两个数
        for (int i = 0; i < A.length-1; i++) {
            if(A[i] >= A[i+1]){
                flag2 = false;
            }else {
                flag2 = true;
                break;
            }
        }
        if (!flag2){
            swap(A,A.length-1,A.length-2);
            return A;
        }
        //数组内的数据是无序的
        for (int i = 0; i < A.length-1; i++) {
            if (A[i] > A[i+1]){
                index = i;
            }
        }
        int max = -1;

        for (int i = index+1; i < A.length; i++) {
            if (A[i] > max && A[i] < A[index]){
                max = A[i];
                max_index = i;
            }
        }
        swap(A,index,max_index);
        return A;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
