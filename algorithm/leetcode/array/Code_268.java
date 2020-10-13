package leetcode.array;

import java.util.Arrays;

/**
 * Missing Number
 */
public class Code_268 {
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
