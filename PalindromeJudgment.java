//判断回文
import java.util.Scanner;

public class PalindromeJudgment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine(); 
        System.out.println(method(A,B));
    }
    public static int method(String A,String B){
        int count = 0;
        //建立新的字符串
        for(int i = 0; i<= A.length();i++){
            StringBuilder str = new StringBuilder(A);
            str.insert(i,B);
            if(isHuiwen(str.toString())){
                count ++ ;
            }
        }
        return count;
    }
    //判断是否为回文
    public static boolean isHuiwen(String str){
        char[] a = new char[str.length()];
        a = str.toCharArray();
        for(int i = 0;i<a.length;i++){
            if(a[i] != a[a.length-1-i]){
                return false;
            }
        }
        return true;
    }
}
