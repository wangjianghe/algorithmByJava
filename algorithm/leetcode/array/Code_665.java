package leetcode.array;

/**
 * Non-decreasing Array
 * 给定一个包含n个整数的数组num，您的任务是检查它是否可以通过最多修改1个元素而变成非递减的。
 * 我们定义一个数组是非递减的，如果nums[i]<=nums[i+1]对每一个i（基于0的）都成立，那么（0<=i<=n-2）。
 */
public class Code_665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) return true;
        int count = 0;
        for (int i = 1; i < nums.length && count < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue; // non-decrease.
            }
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
            count++;
        }
        return count < 2;
    }
    public boolean checkPossibilityTwo(int[] nums) {
        if(nums.length<=2)return true;
        int j=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(j>0)return false;
                if(i-1>=0&&nums[i-1]>nums[i+1])
                    nums[i+1]=nums[i];
                else
                    nums[i]=nums[i+1];
                j++;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
