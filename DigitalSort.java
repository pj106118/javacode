package jing.able.OJ;

/**
 * @describe :  数字分类
 *A1 =能被5整除的数字中所有偶数的和和；
A2 =将被5除后余1的数字按赋予依次进行交替求和和，即计算n1-n2 + n3-n4 ...；
A3 =被5除后余2的数字的个数；
A4 =被5除后余3的数字的平均数，精确到小数点后1位；
A5 =被5除后余4的数字中最大数字。
输出a1,a2,a3,a4,a5
 */
import java.util.Scanner;
public class DigitalSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int [] s = new int[N];
            for(int i =0;i<N ;i++){
                s[i] = in.nextInt();
            }

            int a1 = 0;
            int a2 = 0;
            int a3 = 0;
            double a4 = 0;
            int a5 = 0;
            boolean flag = false;//a2
            int tmp = 1;
            int n = 0;//a4
            for(int i = 0;i<s.length;i++){
                int a = s[i];
                //a1
                if( a % 5 == 0 && a % 2 ==0 ){
                    a1 += a;
                }

                //a2
                if(a % 5 == 1 ){
                    flag = true;
                    a2 += tmp * a;
                    tmp = (-1) * tmp;
                }

                //a3
                if(a % 5 == 2){
                    a3++;
                }

                //a4
                if(a % 5 == 3){
                    a4 += a;
                    n ++;
                }
                //a5
                if(a % 5 == 4 ){
                    if(a5 < a){
                        a5 = a;
                    }
                }
            }

            if(a1 == 0){
                System.out.print("N" + " ");
            }else{
                System.out.print(a1 +" ");
            }
            if(flag){
                System.out.print(a2 +" ");

            }else{
                System.out.print("N" + " ");
            }
            if(a3 == 0){
                System.out.print("N" + " ");
            }else{
                System.out.print(a3 +" ");
            }
            if(n == 0){
                System.out.print("N" + " ");
            }else{
                System.out.printf("%.1f ",a4/n);
            }
            if(a5 == 0){
                System.out.print("N");
            }else{
                System.out.print(a5);
            }

        }
        in.close();
    }
}
