

/**
 * @describe :  组个最小数
 */
import java.util.*;

public class MinimumNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "2 2 0 0 0 3 0 0 1 0";
        String[] a = str.split(" ");
        int index = 0;
        int count = 0;
        for(int k = 0;k<a.length;k++){
            int r = Integer.parseInt(a[k]);
            if( r!= 0){
                count += r;
            }
        }
        int[] array = new int[count];
        for(int i = 0;i<a.length;i++){
            for(int j = 1;j <= Integer.parseInt(a[i]);j++){
                array[index++] = i;
            }
        }
        for(int i = 0;i<count;i++){
            if(array[i] != 0){
                int tmp = array[i];
                array[i] = array[0];
                array[0] = tmp;
                break;
            }
        }

        for(int j = 0;j<count;j++){
            System.out.print(array[j]);
        }
    }
}
