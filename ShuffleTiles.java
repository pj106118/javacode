import java.util.*;
//现在需要洗2n张牌,从上到下依次是第1张,第2张,第3张一直到第2n张。首先,我们把这2n张牌分成两堆,左手拿着第1张到第n张 （上半堆)，右手拿着第n+1张到第2张(下半堆)。接着就开始洗牌的过程,先放下右手的最后一张牌,再放下左手的最后一张牌,接着放下右手的倒数第二张牌,再放下左手的倒数第二张牌,直到最后放下左手的第一张牌。接着把牌合并起来就可以了。例如有6张牌,最开始牌的序列是 1,2,3,4,5,6,首先分成两组,左手拿着1,23;右手拿着4,5,6,在洗牌过程中按顺序放下了6,3,5,2,4,1,把这六张牌再次合成一组牌之后,我们按照从上往下的顺序看这组牌,就变成了序列!1,4,2,5,3,6,现在给出一个原始牌组,请输出这副牌洗牌k次之后从上往下的序列。
public class Shuffletiles  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int T = sc.nextInt();//组数
            for(int p = 0;p < T;p++){
                
                int n = sc.nextInt();//2n个数
                int k = sc.nextInt();//k次排序

                int[] array = new int[2*n];
                for(int i = 0;i < 2*n;i++){
                    array[i] = sc.nextInt();
                }

                for(int j = 1;j<=k;j++){
                    method(array,n*2);
                }

                for(int m = 0;m<2*n-1;m++){
                    System.out.print(array[m] + " ");
                }
                System.out.println(array[2*n-1]);
            }
        }
        sc.close();
    }
    
    public static void method(int[] array,int N){
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i< N/2;i++){
            list.add(array[i]);
            list.add(array[i+N/2]);
        }
        for(int i = 0;i<N;i++){
            array[i] = list.get(i);
        }
    }
}