package jing.able.Java.OJ;
import java.util.ArrayList;
import java.util.List;
/**
 * @author : panjing
 * @data : 2019/9/10 20:46
 * @describe :
 */
public class Triangle {
    public List<List<Integer>> generate(int numRows) {
        //先定义numRows个List<Integer>
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows ; i++) {
            list.add(new ArrayList<>());
        }
        //先全部用1填充 即[   [1],[1,1],[1,1,1]......]
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < i+1; j++) {
                list.get(i).add(1);
            }
        }
        //修改需要修改的地方
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j <= i -1; j++) {
                int a = list.get(i-1).get(j-1);
                int b = list.get(i-1).get(j);
                list.get(i).set(j,a + b);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(new Triangle().generate(6));
    }
}
