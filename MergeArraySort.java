//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
import java.util.*;
public class MergeArraySort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        int index = 0;
        for(int i = m;i<nums1.length;i++){
            nums1[i] = nums2[index];
            index++;
        }
        Arrays.sort(nums1);
    }
}