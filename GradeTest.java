package jing.able;

import java.util.Scanner;

public class GradeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //输入课程数n
        int n = sc.nextInt();
        int[] a = new int[n]; //存放学分的数组
        int[] b = new int[n];//存放对应成绩的数组
        float sum = 0;
        int v = 0;//存放学分的总和
        //输入相应课程学分
        for(int i = 0;i< n;i++){
            a[i] = sc.nextInt();
            v += a[i];
        }
        //成绩
        for(int i = 0;i<n;i++){
            b[i] = sc.nextInt();
        }

        for(int i = 0;i<n;i++){
            int grade = b[i];

            if(grade>=90){
                sum +=4.0*a[i];
            }
            if(grade>=85&&grade <= 89){
                sum +=3.7*a[i];
            }
            if(grade <= 84 && grade>=82 ){
                sum +=3.3*a[i];

            }
            if(grade <= 81 && grade>=78){
                sum +=3.0*a[i];
            }
            if(grade <= 77 && grade>=75 ){
                sum +=2.7*a[i];
            }
            if(grade <= 74 && grade>=72){
                sum +=2.3*a[i];
            }
            if(grade<=71 && grade>=68 ){
                sum +=2.0*a[i];
            }
            if( grade<=67 && grade>=64){
                sum +=1.5*a[i];
            }
            if(grade<=63 && grade>=60){
                sum +=1.0*a[i];
            }
            if(grade<60){
                sum += 0;
            }

        }

        System.out.println(String.format("%.2f",sum/v));//返回一个两位小数的数
    }
}