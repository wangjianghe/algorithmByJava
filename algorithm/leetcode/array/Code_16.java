package leetcode.array;

import java.util.Arrays;
//三数之和，返回最接近target的目标之和
public class Code_16 {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length==3){
            return nums[0]+nums[1]+nums[2];
        }
        Arrays.sort(nums);
        int minValue=nums[0]+nums[1]+nums[2];
        for (int i=0;i<nums.length;i++){
            if (i>0&&nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int addSum=nums[i]+nums[left]+nums[right];
                if (Math.abs(target-addSum)<Math.abs(target-minValue)){
                    minValue=addSum;
                }
                if (addSum<target){
                    left++;
                }else if (addSum>target){
                    right--;
                }else{
                    return addSum;
                }
            }
        }
        return minValue;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},-1));
    }
}
