import java.util.*;
public class RichAndStrange {
//一个百万富翁遇到一个陌生人，陌生人找他谈了一个换钱的计划。该计划如下：我每天给你10 万元，你第一天给我1 分钱，第二天2 分钱，
//第三天4 分钱……这样交换 30 天后，百万富翁交出了多少钱？陌生人交出了多少钱？（注意一个是万元，一个是分）
//输出两个整数，分别代表百万富翁交出的钱和陌生人交出的钱，富翁交出的钱以万元作单位，陌生人交出的钱以分作单位。
    public static void main(String[] args) {
        //strange是陌生人，rich是有钱人，strange每天给rich 10万元，rich第一天给2分，第二天给4分
        int strange = 0;
        int rich = 0 ;
        strange = 10*30; //万元
        rich =(int)( Math.pow(2,30) - 1);
        System.out.print(strange + " " + rich);
    }
}