package leetcode.face;

import java.util.Arrays;

public class 最长递增序列 {
    //动态规划
    public static int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp,1);
        for(int i = 0; i < nums.length - 1; i++ ){
            if(nums[i + 1] > nums[i]){   //判断连续
                dp[i + 1] = dp[i] + 1;   // 递推，只需要与前面一个元素比较即可
            }
            if(dp[i + 1] > res) res = dp[i + 1];
        }
        return res;
    }
}
//贪心代码（空间复杂度为O(1)）
class Solution {
    public int findLengthOfLCIS(int[] nums) {

        int res = 1;
        int count = 1;

        for(int i = 0; i < nums.length - 1; i++ ){
            if(nums[i + 1] > nums[i]){   // 判断连续
                count++;
            }else{
                count = 1;
            }
            if(count > res) res = count;
        }
        return res;
    }
}
