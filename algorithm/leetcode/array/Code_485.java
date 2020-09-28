package leetcode.array;

/**
 * 给定一个二进制数组，请找到该数组中最大连续1个数。
 */
public class Code_485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive=0;
        int start=-1;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==1&&start==-1){
                start=i;
            }
            if (nums[i]==0&&start!=-1){
                if (i-start>maxConsecutive){
                    maxConsecutive=i-start;
                }
                start=-1;
            }
        }
        if (start!=-1){
            if (nums.length-start>maxConsecutive){
                maxConsecutive=nums.length-start;
            }
        }
        return maxConsecutive;
    }

    public static int findMaxConsecutiveOnesTwo(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(count, max);
    }
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
}
