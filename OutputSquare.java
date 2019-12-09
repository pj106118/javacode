package jing.able.OJ;

/**
 * @describe :  跟奥巴马一起编程
 */
import java.util.Scanner;

public class OutputSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();  //列
        String str = sc.next();
        char c = str.charAt(0);
        int row ;

        if(col%2==0){
            row = col/2;
        }else{
            row = col/2 + 1;
        }

        for(int i = 1;i<=row;i++){
            for(int j = 1;j<=col;j++){
                if(i==1||i==row){
                    System.out.printf("%c",c);
                }else if(j==1||j==col){
                    System.out.printf("%c",c);
                }else{
                    System.out.printf(" ");
                }
            }
            System.out.println();
        }
    }
}
