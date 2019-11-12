//已知A-B, B-C, A+ B, B+C 这四个数值.现在需要通过这四个数值计算A,B,C分别为多少
import java.util.*;
public class CalculateNumber {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int m=input.nextInt();
        int n=input.nextInt();
        int p=input.nextInt();
        int q=input.nextInt();
        if ((m+n)!=(p-q)){
            System.out.println("No");
        }else {
            int A=(m+p)/2;
            int B=(n+q)/2;
            int C=q-B;
            System.out.println(A+" "+B+" "+C);
        }
    }
}
/*

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        
        int A = (a+c)/2;
        int B = (c-a)/2;
        int C = (d - b)/2;
        
        if(A-B==a && B-C == b && A+B ==c && B+C == d){
            System.out.println(A+" "+B +" "+C);
        }else{
            System.out.println("No");
        }
        
        
    }
}
*/