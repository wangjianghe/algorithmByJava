package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个排序整数数组，其中元素的范围为[下，上]包含在内，返回其缺少的范围。
 */
public class Code_163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        //special case
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            group(res, lower, upper);
            return res;
        }
        if (nums[0] != lower) {
            group(res, lower, nums[0] - 1);
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1 && nums[i] != nums[i - 1]) {
                group(res, nums[i - 1] + 1, nums[i] - 1);
            }
        }
        if (nums[nums.length - 1] != upper) {
            group(res, nums[nums.length - 1] + 1, upper);
        }
        return res;
    }

    public void group(List<String> res, int start, int end) {
        StringBuilder sb = new StringBuilder();
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start);
            sb.append("->");
            sb.append(end);
        }
        res.add(sb.toString());
    }
}
