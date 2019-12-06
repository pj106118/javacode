package jing.able.OJ;

/**
 * @author : panjing
 * @data : 2019/12/3 11:16
 * @describe :  最高分是多少
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 */


import java.util.*;
public class MaxGrade {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {

            int N = in.nextInt();
            int M = in.nextInt();

            int[] grade = new int[N];
            for (int i = 0; i < N; i++) {
                grade[i] = in.nextInt();
            }

            int[] result = new int[N];
            int index = 0;

            for (int j = 0; j < M ; j++) {
                String str = in.next();
                int a = in.nextInt();
                int b = in.nextInt();
                if (str.equals("Q")) {//询问
                    result[index++] = max(
                            grade,a-1,b-1);
                }
                if (str.equals("U")) {
                    grade[a-1] = b;
                }
            }

            for (int j = 0; j < index; j++) {

                System.out.println(result[j]);
            }
        }
        in.close();
    }

    private static int max(int[] score, int v, int w) {
        int max = score[v];
        if(v < w) {
            for(int i = v; i <= w; i++) {
                if(score[i] > max)
                    max = score[i];
            }
        }else{
            for(int i = v; i >= w; i--) {
                if(score[i] > max)
                    max = score[i];
            }
        }
        return max;
    }
}
