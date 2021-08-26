package leetcode.array;
//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须 原地 修改，只允许使用额外常数空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1]
//输出：[1,2,3]
//
//
// 示例 3：
//
//
//输入：nums = [1,1,5]
//输出：[1,5,1]
//
//
// 示例 4：
//
//
//输入：nums = [1]
//输出：[1]
public class Code_31 {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int index=n-1;
        while (index-1>=0&&nums[index]<=nums[index-1]) index--;
        if (index==0){
            //没有出现小于的情况
            reserveArray(0,n-1,nums);
            return;
        }
        int left=index;
        while (left+1<n&&nums[left+1]>nums[index-1]) left++;
        swap(index-1,left,nums);
        reserveArray(index,n-1,nums);
    }
    public void reserveArray(int l,int r,int[] nums){
        for (;l<r;l++,r--){
            swap(l,r,nums);
        }
    }
    public void swap(int l,int r,int[] nums){
        int swap;
        swap=nums[l];
        nums[l]=nums[r];
        nums[r]=swap;
    }
}
