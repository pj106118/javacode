package jing.able.DS.SuperList;

import java.util.Arrays;

/**
 * @author : panjing
 * @data : 2019/9/3 20:36
 * @describe : 顺序表（数据在数组中）
 */
public class ArrayList extends List {
    int[] array = new int[10];

    @Override
    public void insert(int index, int element) {
        for (int i = size; i > index ; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
        System.out.println(Arrays.toString(Arrays.copyOfRange(array,0,size)));
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.insert(0,1);
        list.insert(1,2);
        list.insert(2,3);

    }
}
