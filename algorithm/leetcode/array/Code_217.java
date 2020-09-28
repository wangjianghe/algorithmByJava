package leetcode.array;

import java.util.Arrays;

/**
 * 如果重复为true
 */
public class Code_217 {
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length==1){
            return false;
        }
        if(nums.length==0){
            return false;
        }
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]==nums[i+1])
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{3,1}));
    }
}
