package jing.able.Java;
import java.util.Scanner;

public class FindNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(findnum(str));
        }
        sc.close();
    }

    public static String findnum(String str) {
        String a2 = "ABC";
        String a3 = "DEF";
        String a4 = "GHI";
        String a5 = "JKL";
        String a6 = "MNO";
        String a7 = "PQRS";
        String a8 = "TUV";
        String a9 = "WXYZ";
        String b = "";
        if (str.length() == 8 ) {
            for (int i = 0; i < str.length(); i++) {
                if(b.length()==3){
                    b = b + "-";
                }
                if (a2.contains(str.charAt(i)+"")) {
                    b += 2;
                }
                if (a3.contains(str.charAt(i)+"")) {
                    b += 3;
                }
                if (a4.contains(str.charAt(i)+"")) {
                    b += 4;
                }
                if (a5.contains(str.charAt(i)+"")) {
                    b += 5;
                }
                if (a6.contains(str.charAt(i)+"")) {
                    b += 6;
                }
                if (a7.contains(str.charAt(i)+"")) {
                    b += 7;
                }
                if (a8.contains(str.charAt(i)+"")) {
                    b += 8;
                }
                if (a9.contains(str.charAt(i)+"")) {
                    b += 9;
                }

        }
    }
        return b;
    }
}