//有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，
//假如兔子都不死，问每个月的兔子总数为多少？

import java.util.Scanner;
public class Rabbit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         while (sc.hasNextInt()) {
        int month = sc.nextInt();
        System.out.println(count(month));
         }
        sc.close();
    }
    public static int count(int month){
        if(month==1||month==2){
            return 1;
        }
        if(month == 0 ){
            return 0;
        }
        else{
        return count(month-1)+count(month-2);
        }
    }
}