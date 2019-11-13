import java.util.*;
//用三个空瓶兑换一瓶饮料，输入任意一个数字可以兑换多少瓶饮料？
public class ChangeBottle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
        int n = sc.nextInt();
        System.out.println(Number(n));
        }
    }
    
    
    public static int Number(int n){
        int target = 0;
        while(n>2){
            target = target + n/3;  //兑换瓶子数
            n = n/3 + n%3;   //空拼子数
        }
        if(n == 2){
            target++;
        }
        return target;
    }
}