package leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案
 */
public class Code_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] resultArray=new int[2];
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    resultArray[0]=i;
                    resultArray[1]=j;
                    return resultArray;
                }
            }
        }
        return null;
    }
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] resultArray=new int[2];
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                resultArray[0]=map.get(target-nums[i]);
                resultArray[1]=i;
                return resultArray;
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
