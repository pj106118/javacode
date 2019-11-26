import java.util.Scanner;
//小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
public class Hunger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(count(n));
    }
    public static int count(int n){
        if(n==0){
            return 0;
        }
        long  result = 2 , tmp = 2;
        int i = 0;
        for(i=2;i<100_000*3;i++){
            result = (result * 2) % 1000000007;
            tmp = (result * (n+1)-1)%1000000007;
            if(tmp == 0){
                if(i%3==0){
                    return i/3;
                }else{
                    return i/3+1;
                }
            }
        }
        if(i == 100000*3){
            return -1;
        }
        return 0;
    }
}