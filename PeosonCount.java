import java.util.Scanner;
//统计同成绩的人数
public class PeosonCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i]= sc.nextInt();
        }
        int count = 0;
        int grade = sc.nextInt();
        for(int i = 0; i < n; i++){
            if(a[i] == grade){
                count++;
            }
        }
        System.out.println(count);
    }
}