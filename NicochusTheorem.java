/**
 * @describe :  尼科彻斯定理
 */
import java.util.Scanner;

public class NicochusTheorem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            System.out.println(GetSequeOddNum(m));
        }
        sc.close();
    }
    public static String GetSequeOddNum(int m){
        if(m>100||m<1){
            return null;
        }
        String result = "";
        for(int i = m * (m-1) + 1;i < m*(m+1);i+=2){
            result += i;
            if(i != m*(m+1)-1){
                result += "+";
            }
        }
        return result;
    }
}
