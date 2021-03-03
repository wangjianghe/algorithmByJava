package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
public class Code_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int numsLength=nums.length;
        List<List<Integer>> result=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (i>0&&nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right=numsLength-1;
            while (left<right){
                while (left>i+1&&left<numsLength&&nums[left]==nums[left-1])
                    left++;
                if (left>=right){
                    break;
                }
                int addSum=nums[i]+nums[left]+nums[right];
                if (addSum==0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                }else if (addSum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
