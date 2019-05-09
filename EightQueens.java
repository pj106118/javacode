package jing.able;

/**
 * @author: panjing
 * @describe: 八皇后问题
 * @date: 2019/4/28
 * @time: 8:31
 */

public class EightQueens {
    // 从行来遍历，
    // 三个函数：一个判断列的开始
    // 另一个判断列是否满足条件
    // 第三个输出
    // 全文中i为行，j代表列
        public static void main(String[]args) {
            //摆放每行的皇后放在哪列
            //index[0]=0，代表第一个皇后放在第0列。
            int []index= new int[8];
            //初始化每个皇后是否存在，如果列数为-1，代表不存在
            for(int i=0;i<8;i++)
            {
                index[i]=-1;
            }
            //第一个设置在第一列
            index[0]=0;
            //k为现在寻找的皇后
            int k=1;
            //找完8个皇后
            while(k<=7){
                int j;
                j=startlie(k,index);
                //理论大于0就可以，因为第一个皇后位置为0列，所以其他皇后不能再0列
                if(j>=0){
                    index[k]=j;
                    k++;
                }
                else
                {
                    //要将当前不合适的皇后的位置置1，
                    // 理由：比如当前正在寻找k=5，即第六个皇后，第六个皇后没找到正确位置，回溯第五个皇后
                    //此时可能觉得不用将第六个皇后的位置置为-1；因为正在找第六个皇后，所以第六个皇后的位置还是初始化的-1，
                    //但假如回溯第五个皇后也没找到正确位置，而第五个皇后存着的位置为原先位置，
                    // 此时第五个皇后的位置就要变为-1了，然代表没找到第五个皇后，所以需要将没找到的皇后的位置置为-1.
                    index[k]=-1;
                    k--;
                    //
                }
            }
            for(int i=0;i<8;i++)
            {
                index[i]=index[i]*2+1;
                //System.out.print(index[i]);
            }
            pp(index);
        }
        public static int startlie(int k,int index[]){

            //体现了回溯的想法，如果这时传来的第k行的皇后的列数为-1
            //代表该皇后不存在，则从头开始判断；
            //如果第k行的皇后有列数，说明之前传入的不正确，
            //所以从该列数向后一列进行寻找。
            int lie;
            if(index[k]==-1)
            {
                lie=0;
            }
            else
                lie=index[k]+1;
            for(int j=lie;j<8;j++)
            {
                if(isvaild(k,j,index))
                {
                    return j;
                }
            }
            return -1;
        }
        public static boolean isvaild(int k,int j,int index[])
        {

            //j为当前判断的列
            //判断是否与之前的那些皇后在一个列
            //一直寻找到第k-1个皇后，即上一个皇后
            for(int i=0;i<k;i++)
            {
                if(index[i]==j)
                {
                    return false;
                }
            }
            //判断当前列是否在上一个皇后的右下斜线上；
            // k为当前寻找的皇后，故上一个皇后为k-1
            //xo
            //ox
            //此时当前列向前一列就会和上一个八皇后的列位置相同
            //xoo
            //ooo
            //oox
            //此时需向前两列去比较上上一个八皇后
            for (int lie=j-1,hang=k-1;lie>=0&&hang>=0;lie--,hang-- )
            {
                if(index[hang]==lie) {
                    return false;
                }
            }
            //判断当前列是否在上一个皇后的右下斜线上；
            //ox
            //xo
            //当前列向后一列，就会与上一个皇后相的列数相等
            for (int lie=j+1,hang=k-1;lie>=0&&hang>=0;lie++,hang-- )
            {
                if(index[hang]==lie)
                {
                    return false;
                }
            }
            return true;
        }
        public static void pp(int []index)
        {
            //0，4，7，5，2，6，1，3
            //int[] index ={1,9,15,11,5,13,3,7};
            //int n;
            for(int i=0;i<8;i++) {
                for (int j = 0; j <= 16; j++) {
                    if (j % 2 != 0) {
                        if (j == index[i]) {
                            System.out.print("Q");
                        } else
                            System.out.print(" ");
                    }
                    else if(j%2==0){
                        System.out.print("|");
                    }
                }
                System.out.println("");
            }


        }

    }