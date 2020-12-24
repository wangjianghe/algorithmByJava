package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组nums。
 * 如果nums[i]==nums[j]且i<j，则称一对（i，j）为good。
 * 返回正确对数。
 */
public class Code_1512 {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int[] freq = new int[101];
        for(int a : nums){
            count += freq[a]++;
        }
        return count;
    }
    public int numIdenticalPairsTwo(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int sum = 0;
        for (Integer v : map.values()) {
            int count = v * (v-1);
            sum += count/2;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
