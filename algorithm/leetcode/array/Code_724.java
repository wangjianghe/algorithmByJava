package leetcode.array;

import java.util.Arrays;

/**
 * 计算出 某个轴的左右之和相同，如何不存在返回-1，如果存在多个轴，已最左为准
 */
public class Code_724 {
    public int pivotIndexTwo(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
    public static int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        sum=Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
         //
        System.out.println(pivotIndex(new int[]{1,2,3}));
    }
}
