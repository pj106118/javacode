package jing.able;
import java.util.Scanner;
/**
 * @author: panjing
 * @describe:  利用分治法求一组数据的最大值和最小值
 * @date: 2019/4/8
 * @time: 18:50
 */
public class PrintMaxMin {
    public static void max_min(int[] array,int left,int right,int[] max,int[] min) {
        if (left==right){
            //当只有一个元素时候，直接得出最大值和最小值
            max[0]=array[left];
            min[0]=array[right];
        } else if (left+1==right){
            //当数组中有两个元素时，直接判断哪个元素大
            if (array[left]>array[right]) {
                max[0]=array[left];
                min[0]=array[left];
            } else{
                max[0]=array[right];
                min[0]=array[left];
            }
        } else{
            //当数组元素的个数大于2以上的操作
            int m=(left+right)/2;
            int[] lmax={0};
            int[] lmin={0};
            int[] rmax={0};
            int[] rmin={0};
            max_min(array,left,m,lmax,lmin);
            max_min(array,m+1, right, rmax, rmin);
            if(lmax[0]>rmax[0])
            {
                max[0]=lmax[0];
            } else {
                max[0]=rmax[0];
            }

            if(lmin[0]<rmin[0]) {
                min[0]=lmin[0];
            } else {
                min[0]=rmin[0];
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("请输入数组长度：");
        Scanner input = new Scanner(System.in);
        int len = input.nextInt();

        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            System.out.println("请输入一个数字：");
            array[i] = input.nextInt();
        }
        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int []Max=new int[1];  //java对于实参传递，是采用值传递，所以要改成数组，不能直接使用变量去计算最大值和最小值。
        int []Min=new int[1];
        new PrintMaxMin().max_min(array,0,array.length-1,Max,Min);

        System.out.println("最大值："+ Max[0]);
        System.out.println("最小值："+ Min[0]);
    }
}
