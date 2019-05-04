package jing.able;

/**
 * @author: panjing
 * @describe: 快速排序
 * @date: 2019/4/28
 * @time: 20:25
 */

//时间复杂度：nlogn
public class Qsort {
//1.
    public static int partionSort(int[] array,int low,int high){
        int tmp = array[low];
        while(low < high){
            while(low<high && array[high] >= tmp){
                high--;
            }
            if(low == high){
                break;
            }else{
                array[low] = array[high];
            }

            while(low<= high && array[low] <=tmp){
                low++;
            }
            if (low == high){
                break;
            }else{
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return low;
    }

    //2.递归
    public static void quick(int[]array ,int low,int high){
        if(low == high){
            return;
        }
        takeThreeNumber(array,low,high);

        int par = partionSort(array,low,high);
        //递归保证左边有两个数以上
        if (par>low+1){
            quick(array,low,par-1);
        }
        //递归右边
        if (par < high - 1){
            quick(array,par+1,high);
        }
    }
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }

    //array[mid] <= array[low] <= array[high]
    public static void takeThreeNumber(int[] array,int low,int high){
        int mid = (low+high)/2;
        if(array[mid] > array[low] ){
            swap(array,mid,low);
        }
        if (array[mid] > array[high] ){
            swap(array,mid,high);
        }
        if (array[low] >array[high]){
            swap(array,low,high);
        }
    }

    private static void swap(int[] array,int low, int high) {
        int tmp = array[high];
        array[high] = array[low];
        array[low] = tmp;
    }


}

