package jing.able;

/**
 * @author: panjing
 * @describe:  百马百担问题:有100匹马,驮100担货,大马驮3担,中马驮2担,两匹小马驮1担,问有大,中,小马多少匹
 * @date: 2019/4/8
 * @time: 18:38
 */

public class Horse {
    public static void main(String[] args){
        for(int i = 0;i <= 33; i++)
            for(int j = 0;j <= 50;j++){
                int k = 100 - i- j;
                if((3 * i + 2 * j + k/2 == 100) && (k % 2 == 0)){
                    System.out.println("大马数量为："+ i +",  " + "中马数量为："+ j + ",  " + "小马数量为：" + k);
                }
            }
    }

}
