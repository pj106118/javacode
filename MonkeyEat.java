package jing.able;
/**
 * @author panjing
 * @describe:  猴子吃桃问题：  猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个
 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个以后每天早上都吃了前一天剩下的一半零一个。
 * 到第10天早上想再吃时，见只剩下一个桃子了,求第一天共摘了多少
 * @date 2019/4/8
 * @time 16:22
 */
public class MonkeyEat {
    public static void main(String[] args) {
        System.out.println(total(1));
        System.out.println(total(2));
        System.out.println(total(3));
        System.out.println(total(4));
        System.out.println(total(5));
        System.out.println(total(6));
        System.out.println(total(7));
        System.out.println(total(8));
        System.out.println(total(9));
        System.out.println(total(10));
    }

    /**
     * 每天桃子数量
     * @param day 第几天
     * @return 该天桃子数量
     */
    static int total(int day) {
        if (day == 10) {
            return 1;
        } else {
            return (total(day + 1) + 1) * 2;
        }
    }
}
