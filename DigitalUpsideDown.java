import java.util.Scanner;
//输入一个整数，将这个整体以同轴的形式逆序输出
//程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001 
public class DigitalUpsideDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = "";
        while(n>9){
            str += n%10;
            n = n/10;
        }
        str += n;  //这一步一定不能忘记
        System.out.println(str);
    }
}