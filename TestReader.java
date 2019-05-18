package jing.able.IO;

/**
 * @author: panjing
 * @describe:   通过文件读取数据
 * @date: 2019/5/18
 * @time: 22:46
 */
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
public class TestReader {
    public static void main(String[] args) throws Exception{
// 1.定义文件路径
        File file = new File("C:\\Users\\潘晶\\Desktop\\stream.txt");
// 2.必须保证文件存在才能进行处理
        if (file.exists()) {
            Reader in = new FileReader(file) ;
            char[] data = new char[1024] ;
            int len = in.read(data) ; // 将数据读取到字符数组中
            String result = new String(data, 0, len) ;
            System.out.println("读取内容【"+result+"】") ;
            in.close();
        }
    }
}
