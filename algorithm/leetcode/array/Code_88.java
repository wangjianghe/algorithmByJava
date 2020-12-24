package leetcode.array;

import java.util.Arrays;

/**
 * Merge Sorted Array
 */
public class Code_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,nums2.length);
        Arrays.sort(nums1);
    }
    public static void mergeTwo(int[] nums1, int m, int[] nums2, int n){
        int j = 0;
        for(int i = m;i<m+n;i++) {
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
    }
    public static void main(String[] args) {
        int[] nums1 ={1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1,m,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
