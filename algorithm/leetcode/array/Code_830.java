package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Positions of Large Groups
 * In a string s of lowercase letters, these letters form consecutive groups of the same character.
 * For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".
 * A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group.
 * In the above example, "xxxx" has the interval [3,6].
 * A group is considered large if it has 3 or more characters.
 * Return the intervals of every large group sorted in increasing order by start index.
 */

/**
 * 在小写字母的字符串中，这些字母构成相同字符的连续组。
 * 例如，像s=“abbxxzyy”这样的字符串具有组“a”、“bb”、“xxxx”、“z”和“yy”。
 * 组由一个区间[start，end]标识，其中start和end表示组的开始和结束索引（包括）。在上例中，“xxxx”具有间隔[3,6]。
 * 如果一个组有3个或更多的字符，则认为它是大的。
 * 返回按开始索引按递增顺序排序的每个大组的间隔。
 */
public class Code_830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = s.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N-1 || s.charAt(j) != s.charAt(j+1)) {
                if (j-i+1 >= 3)
                    ans.add(Arrays.asList(i, j));
                i = j + 1;
            }
        }
        return ans;
    }
}
