package leetcode.array;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器。
//重点 双指针
public class Code_11 {
    public static int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxArea=0;
        while (i<j){
            maxArea=Math.max(Math.min(height[i],height[j])*(j-i),maxArea);
            if (height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}
