package leetcode.array;

import java.util.*;

/**
 * Check If N and Its Double Exist
 * 给定一个整数数组，检查是否存在两个整数N和M，使得N是M的双精度（即N=2*M）。
 * 更正式地检查是否存在两个指数i和j，以便：
 */
public class Code_1346 {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for (int i:arr){
            if (set.contains(i*2)||set.contains(i/2)&&i%2==0){
                return true;
            }
            set.add(i);
        }
        return false;
    }
    public boolean checkIfExistTwo(int[] arr){
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int value : arr) {
            int count = map.getOrDefault(value, 0);
            map.put(value, count + 1);
            if (map.containsKey(2 * value) || (value % 2 == 0 && map.containsKey(value / 2))) {
                if (value == 0 && map.get(0) == 1) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}
