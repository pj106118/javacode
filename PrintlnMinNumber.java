package jing.able.OJ;

/**
 * @author : panjing
 * @data : 2020/1/4 22:05
 * @describe :  输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintlnMinNumber {
        public static String PrintMinNumber(int [] numbers) {
            String result="";
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0;i<numbers.length;i++){
                list.add(numbers[i]);
            }
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    String s1 = o1+""+o2;
                    String s2 = o2+""+o1;
                    return s1.compareTo(s2);
                }
            });

            for(int k:list){
                result += k;
            }
            return result;
        }

    public static void main(String[] args) {
        int[] numbers = {3,32,321};
        System.out.println(PrintMinNumber(numbers));
    }
}
