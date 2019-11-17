import java.util.Scanner;
//末尾有多少0
public class Countof0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rs = 0;
        while(n>0){
            rs += n/5;
            n /= 5; 
        }
        System.out.print(rs);
    }
}