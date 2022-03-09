package leetcode.face;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
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
}
