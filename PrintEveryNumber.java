//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
//例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
//则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,
import java.util.*;
public class PrintEveryNumber {
    public ArrayList<Integer> printMatrix(int [][] a) {
        ArrayList<Integer> list = new ArrayList<>();
        if(a.length == 0 || a[0].length == 0 || a == null){
            return list;
        }
        int left = 0;
        int right = a[0].length-1;
        int up = 0;
        int down = a.length-1;
        
        while(true){
            for(int i = left; i <= right;i++){
                list.add(a[up][i]);
            }
            up++;
            if(up > down){
                break;
            }
            for(int i = up;i <= down;i++){
                list.add(a[i][right]);
            }
            right--;
            if(right < left){
                break;
            }
            for(int i = right;i>=left;i--){
                list.add(a[down][i]);
            }
            down--;
            if(down<up){
                break;
            }
            for(int i = down;i>=up;i--){
                list.add(a[i][left]);
            }
            left++;
            if(left>right){
                break;
            }
        }
        return list;
    }
}