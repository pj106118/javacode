import java.math.BigInteger;
import java.util.Scanner;
public class AddLongInteger2 {
//长整数加法
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String addend = sc.nextLine();
            String augend = sc.nextLine();
            System.out.println(AddLongInteger(addend,augend));
        }

    private static String AddLongInteger(String addend, String augend) {
        BigInteger A = new BigInteger(addend,10);
        BigInteger B = new BigInteger(augend,10);

        BigInteger sum = A.add(B);

        return sum+"";
    }

}
