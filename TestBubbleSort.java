package jing.able;
import java.util.Arrays;
public class TestBubbleSort {
        public  static void bubbleSort(int[] array){

            for(int end = array.length;end>0;end--){
                boolean result = true;
                for(int i= 1;i < end;i++) {
                    if (array[i-1] > array[i ]) {
                        int temp = array[i-1];
                        array[i-1] = array[i ];
                        array[i ] = temp;
                        result = false;
                    }
                }
                if(result==true){
                        break;
                    }

            }

        }
        public static void main(String[] args) {
            int[] array ={33,51,12,23,21,55};
            System.out.println(Arrays.toString(array));
            bubbleSort(array);
            System.out.println(Arrays.toString(array));
        }
}
