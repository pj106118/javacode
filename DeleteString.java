//删除字符串的三种方式
import java.util.*;
public class DeleteString{
	//第一种
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            String s = sc.nextLine();
            int index = 0;
            Map<Integer,Character> map = new TreeMap<>();
            for(int i = 0;i<s.length();i++){
                map.put(index,s.charAt(i));
                index++;
            }
            for(int i = 0;i<str.length();i++){
                if(!map.containsValue(str.charAt(i))){
                    System.out.println(str.charAt(i));
                }
            }
        }
		
/*	
第二种	
import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String pattern = "[" + s2 + "]";
            String result = s1.replaceAll(pattern, "");
            System.out.println(result);
        }
    }
}
*/


/*
第三种
import java.util.Scanner;

public class Main{
	public static void main(String[] args){

	    Scanner sc = new Scanner(System.in);
	    while(sc.hasNext()){
		    char[] ch = sc.nextLine().toCharArray();
		    String str = sc.nextLine();
		    for(int i=0;i<ch.length;i++){
			    if(!str.contains(String.valueOf(ch[i]))){
				System.out.print(ch[i]);
			   }
		    }
	    }
    }
}
*/
    }
