package jing.able;

import java.io.*;
import java.util.Scanner;

/**
 * @author: panjing
 * @describe: 如果名为 Exercise 12_15.txt的文件不存在，则创建该文件使用文本I/O将随机产生的
 * 100个整数写入文件，文件中的整数由空格分开，从文件中读回数据并以升序显示数据
 * @date: 2019/5/19
 * @time: 13:35
 */

public class TestReadFile {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\潘晶\\Desktop\\Exercise12_15.txt");
        if (!(file.exists())){
            //对文件进行输入
            PrintWriter out = new PrintWriter(file);
            for (int i = 1; i <= 100; i++) {
                out.print((int)(Math.random()*100 )+" "); //产生0到100的随机数
            }
            out.close();
        }
        //对文件的输出
        Scanner scanner = new Scanner(file);
        int[] num = new int[100];
        for (int i = 0; i < 100; i++) {
            num[i] = scanner.nextInt();
        }
        java.util.Arrays.sort(num);
        for (int i = 0; i < 100; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
