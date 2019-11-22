 //给定长，宽，每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
//对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
// ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
//最多可以放多少块蛋糕在网格盒子里。
import java.util.*;
public class HavingTwo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int count = 0; 
        if(H%4==0||W%4==0){
            count = H*W/2;
        }else{
                 count = H*W/2+1;
        }
        System.out.println(count);
    }
}