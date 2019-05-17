package jing.able;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author: panjing
 * @describe:
 * @date: 2019/5/17
 * @time: 19:42
 */

public class PrintStreamTest {
    public static void main(String[] args)throws IOException {
        File file = new File("C:\\Users\\潘晶\\Desktop\\stream.txt");
        Scanner scanner = new Scanner(new FileInputStream(file));
        while(scanner.hasNext()){
            String str = scanner.next();
            System.out.println("输入内容为："+str);
        }
        scanner.close();
    }
}
