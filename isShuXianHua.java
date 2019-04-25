package jing;

/**
 * @author: panjing
 * @describe: 打印所有的水仙花数（水仙花数就是指一个三位数的各个位的立方和等于它本身）
 * @date: 2019/4/24
 * @time: 19:48
 */

public class isShuXianHua {
    public static void main(String[] args) {
        for (int i = 100; i < 1000 ; i++) {
            if (isShuXianHua(i)){
                System.out.println(i);
            }
        }
    }
    public static boolean isShuXianHua(int num){
     //1.判断是否为三位数
        if(num<100&&num>1000){
            return false;
        }else{//2.拆分 拆成百位，十位，个位
            int gewei = num % 10;
            int shiwei = (num/10) % 10 ;
            int baiwei = (num/100);
            int result = gewei*gewei*gewei+
                    shiwei*shiwei*shiwei+
                    baiwei*baiwei*baiwei;
            if (result == num){
                return true;
            }else{
                return false;
            }
        }
    }
}
