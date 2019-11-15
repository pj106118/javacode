//输入n个整数,输出出现次数大于等于数组长度一半的数。
import java.util.*;
public class HalfLengthArray {  
    public static int getCountHalfLen(int[] arr){
        int[] count = new int[arr.length]; //count[i]表示索引为i出现的次数,统计每个数出现的次数
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count.length; j++) {
                if(arr[i] == arr[j]) count[i]++;
            }
        }
 
        for (int i = 0; i < count.length; i++) {
            if(count[i] >= (arr.length + 1)/2) return arr[i];
        }
        return 0;
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dataStr = sc.nextLine();
        String[] split = dataStr.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        System.out.println(getCountHalfLen(arr));
    }
}