package jing.able;
import java.util.Scanner;
/**
 * @author: panjing
 * @describe:
 * @date: 2019/4/28
 * @time: 17:59
 */

/** 一个正整数有可能可以表示为n(n>=2)个连续的正整数之和，如：
  * //15=1+2+3+4+5,15=4+5+6,15=7+8
  * //请编写程序，根据输入的任何一个正整数，找出符合这种要求的所有连续正整数序列。
  * //例如：输入15，则输出
  * //15=1+2+3+4+5,
  * //15=4+5+6,
  * //15=7+8,若不符合则输出提示信息
  */
public class PrintInteger {
    public static void main(String[] args) {
    Scanner input=new Scanner(System.in);
    int n,sum;
    System.out.print("请输入一个整数：");
    n=input.nextInt();

    boolean flag=false;//用于不符合输出提示信息

    for(int i=1;i<=n/2+1;i++){   //从1--n/2+1数逐一尝试是否满足要求，满足则输出

        sum=0;
     for(int j=i;j<=n/2+1;j++){   //从上一个循环的首位数字连续累加

        sum=sum+j;

      if(sum==n&&sum!=j){     //满足条件n(n>=2)个连续整数相加

          System.out.print(n+"=");
          for(int k=i;k<=j;k++) {
            if(k==j)
              System.out.println(k);
            else
              System.out.print(k+"+");
            flag=true;
          }
      }
     }
    }
    if(!flag)   //没有满足条件
        System.out.println("not found!!");
    }
}
