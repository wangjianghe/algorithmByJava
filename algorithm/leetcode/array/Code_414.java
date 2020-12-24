package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Third Maximum Number
 * 给定一个非空整数数组，返回该数组中第三个最大数。
 * 如果不存在，则返回最大值。时间复杂度必须是O（n）。
 */
public class Code_414 {
    public static int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        boolean hasIntMin = false;
        for (int num : nums) {
            if (num == Integer.MIN_VALUE) hasIntMin = true;
            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num != firstMax && num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num != firstMax && num != secondMax && num > thirdMax) {
                thirdMax = num;
            }
            //System.out.println(firstMax+" "+secondMax+" "+thirdMax);
        }
        if (firstMax == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (secondMax == Integer.MIN_VALUE) return firstMax;
        if (thirdMax == Integer.MIN_VALUE) return hasIntMin ? Integer.MIN_VALUE : firstMax;
        return thirdMax;
    }

    public static int thirdMaxTwo(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        if (list.size() < 3)
            return list.get(list.size() - 1);
        else
            return list.get(list.size() - 3);
    }


    public static void main(String[] args) {
        System.out.println(thirdMaxTwo(new int[]{3, 2, 1}));
    }
}
