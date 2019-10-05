package jing.able.DS.heap;

/**
 * @author : panjing
 * @data : 2019/9/22 14:11
 * @describe:  优先级队列
 */
public class MyPriorityQueue  {

    public static void shiftUPSmall(int[] array,int index){
        while (index != 0){
            int parent = (index-1)/2;
            if(array[parent] > array[index]){
                int tmp = array[parent];
                array[parent] = array[index];
                array[index] = tmp;
                index = parent;
            }else{
                break;
            }
        }

    }
}
