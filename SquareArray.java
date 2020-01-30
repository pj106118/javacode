/*
给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
*/
import java.util.*;
class SquareArray  {
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        for(int i =0;i<A.length;i++){
            B[i] = A[i] *A[i];
        }
        Arrays.sort(B);
        return B;
    }
}