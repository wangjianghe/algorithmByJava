package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains Duplicate II
 * 给定一个整数数组和一个整数k，找出数组中是否有两个不同的索引i和j，
 * 使得nums[i]=nums[j]，i和j的绝对差最多为k。
 */
public class Code_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int i = mid - 1;
        return true;
    }

    public static boolean containsNearbyDuplicateTwo(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicateTwo(new int[]{1, 2, 3, 1}, 3));
    }
}
