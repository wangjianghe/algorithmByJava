package leetcode.array;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

// 示例 1：
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
// 示例 2：
//输入：height = [4,2,0,3,2,5]
//输出：9
// 提示：
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针 动态规划
// 👍 2264 👎 0
public class Code_42 {
    //暴力求解，从第一层算到最高层
    public int trap1(int[] height) {
        int sum = 0;
        int max = getMax(height);//找到最大的高度，以便遍历。
        for (int i = 1; i <= max; i++) {
            boolean isStart = false; //标记是否开始更新 temp
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }
    private int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int cur_left = -1, cur_right = -1;
        int ans = 0;
        while(left < right){
            cur_left = Math.max(cur_left, height[left]);
            cur_right = Math.max(cur_right, height[right]);
            if(cur_left < cur_right){
                ans += cur_left - height[left];
                left++;
            }
            if(cur_left >= cur_right){
                ans += cur_right - height[right];
                right--;
            }
        }
        return ans;
    }
}
