import java.util.*;
//有一个X*Y的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
 //请设计一个算法，计算机器人有多少种走法
// 给定两个正整数int x,int y，请返回机器人的走法数目，保证x＋y小于等于12
public class Robot {
    public int countWays(int x, int y) {
        if(x==1 || y==1){
            return 1;
        }
        return countWays(x-1,y)+countWays(x,y-1);
    }
}