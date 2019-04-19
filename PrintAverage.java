package jing.able;

/**
 * @author: panjing
 * @describe: 求数组平均值
 * @date: 2019/4/13
 * @time: 14:57
 */

public class PrintAverage {
    public static void main(String[] args) {
        int[] array1={1,2,3,4,5,6,7,8,9,10};
        double[] array2 = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("这是int的average"+average(array1));
        System.out.println("这是double的average"+average(array2));
    }
    public static int average(int[] array){
        int sum=0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        }
        int average = sum/array.length;
        return average;
    }
    public static double average(double[] array){
        int sum=0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        }
        double average = sum/array.length;
        return average;
    }
}
