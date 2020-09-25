package leetcode;

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;
import util.TreeNode;
import util.TreeUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 *<p>Description:${Description}</p>
 *<p>Create Date:2020年01月02日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        int[] a={3,3,4};
        Solution solution=new Solution();
        System.out.println(solution.majorityElement(a));
    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int start=nums[0];
        int count=1;
        int majority=nums.length/2;
        for (int i=1;i<nums.length;i++){
            if (nums[i]==start){
                count++;
            }
            if (count>majority){
                return start;
            }
            if (nums[i]!=start){
                start=nums[i];
                count=1;
            }
        }
        return start;
    }

}
