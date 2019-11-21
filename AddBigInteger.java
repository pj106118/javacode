import javax.swing.*;
import java.math.BigInteger;
import java.util.*;
 
 //两个超长正整数的加法
public class AddBigInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        while (sc.hasNext()) {
            String a = sc.nextLine();
            String b = sc.nextLine();

            // 求出两个字符串中较长的那个字符串长度
            int lenA = a.length();
            int lenB = b.length();
            int lenS = Math.max(lenA, lenB);

            // S保存最终生成的结果 
            int[] A = new int[lenS];
            int[] B = new int[lenS];
            int[] S = new int[lenS + 1];
 
            for (int i = 0; i < lenA; i++) {
                A[i] = a.charAt(lenA - 1 - i) - '0';
            }
 
            for (int i = 0; i < lenB; i++) {
                B[i] = b.charAt(lenB - 1 - i) - '0';
            }
 
            for (int i = 0; i < lenS; i++) {
                int sum = S[i] + A[i] + B[i];
                int flag = sum /10;
                S[i]  = sum % 10;
                S[i+1] += flag;
            }
 
            for (int i = (S[lenS] == 0?1:0); i < lenS + 1; i++) {
                System.out.print(S[lenS - i]);
            }
 
            System.out.println();
 
        }
 
        sc.close();
    }
 
}