import java.util.*;
 //输出n个整数里最小的k个数。升序输出
public class PrintSortNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String [] s = str.split(" ");
        int k = Integer.parseInt(s[s.length-1]);
        int [] a = new int[s.length-1];
        for(int i = 0;i<s.length-1 ;i++ ){
            a[i] =Integer.parseInt(s[i]);
        }
        Arrays.sort(a);
        for(int i = 0;i<k;i++){
            System.out.print(a[i] + " ");
        }
    }
}
