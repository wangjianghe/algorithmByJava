package leetcode.array;

/**
 * Longest Continuous Increasing Subsequence
 */

/**
 * 给定未排序的整数nums数组，返回最长连续递增子序列（即子数组）的长度。子序列必须严格递增。
 * 连续递增的子序列由两个指数l和r（l<r）定义，使得它是[nums[l]，nums[l+1]，…，nums[r-1]，nums[r]]，
 * 并且对于每个l<=i<r，nums[i]<nums[i+1]。
 */
public class Code_647 {
    public static int findLengthOflCIS(int[] nums){
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int maxLength = 1;
        int startLength=1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                startLength++;
            }else{
                maxLength=Math.max(startLength,maxLength);
                startLength=1;
            }
        }
        maxLength=Math.max(startLength,maxLength);
        return maxLength;
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,2,3};
        System.out.println(findLengthOfLCIS(array));
        array=new int[]{2,2,2,2};
        System.out.println(findLengthOfLCIS(array));
        array=new int[]{3,1,2,0,6,7,8,9,12};
        System.out.println(findLengthOfLCIS(array));
    }
}
