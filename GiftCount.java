package jing.able.OJ;

/**
 * @author : panjing
 * @data : 2019/11/28 20:09
 * @describe :  春节期间小明使用微信收到很多个红包，非常开心。
 * 在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。
 * 请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
 * 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
 * 若没有金额超过总数的一半，返回0。
 */
import java.util.*;
public class GiftCount {

    public static void main(String[] args) {
        int [] gifts = {1,2,2,3,2};
        System.out.println(getValue(gifts,5));
    }
    public static int getValue(int[] gifts, int n) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i = 0;i<n;i++){
            if(map.containsKey(gifts[i])){

                map.put(gifts[i],map.get(gifts[i])+1);
            }else{
                map.put(gifts[i],1);
            }
        }
        for(int i = 0;i<n;i++){
            if(map.get(gifts[i]) > n/2){
                return gifts[i];
            }
        }
        return 0;
    }
}
