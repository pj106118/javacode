//输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
//以及下划线“_”（代表空格）组成。题目保证2个字符串均非空
import java.util.*;
public class keyBoard{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String right = sc.nextLine();
        String wrong = sc.nextLine();

        Set<Character> set = new TreeSet<>();
        Set<Character> written = new TreeSet<>();

        for(char a : wrong.toCharArray()){
            set.add(a);
        }

        for(char b : right.toCharArray()){
            if(!set.contains(b)){
                b = Character.toUpperCase(b);
                if(!written.contains(b)){
                    System.out.print(b);
                    written.add(b);
                }
            }
        }


    }
}
