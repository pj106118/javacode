//统计每个数出现的次数
import java.util.Scanner;
public class CountofNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int[] a = new int[10];
       for(int i= 0 ;i<n.length();i++){
           a[n.charAt(i)-'0']++;
       }
        
        for(int i = 0;i<a.length;i++){
            if(a[i] != 0){
                System.out.println(i + ":" + a[i]);
            }
        }
    }
}