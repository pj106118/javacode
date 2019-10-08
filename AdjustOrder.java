//输入一个整数数组,实现一个函数来调整该数组中数字的顺序,使得所有的奇数位于数组的前半部分,
//所有的偶数位于数组的后半部分,并保证奇数和奇数,偶数和偶数之间的相对位置不变。
import java.util.*;
public class AdjustOrder {
    public void reOrderArray(int [] array) {
        Arrays.sort(array);
        List<Integer> list1 = new ArrayList<>(); //存放奇数
        List<Integer> list2 = new ArrayList<>(); //存放偶数
        for(int i = 0; i< array.length;i++){
            if(array[i] % 2 == 1){
                list1.add(array[i]);
            }else{
                list2.add(array[i]);
            }
        }
        int k = 0;
        for(int j = 0;j < array.length;j++){
            if(j < list1.size()){
                array[j] = list1.get(j);
            }else{
                
                array[j] = list2.get(k++);
            }
        }
    }
}