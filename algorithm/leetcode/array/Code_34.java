package leetcode.array;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 进阶：
//
//
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//
//
//
//
// 示例 1：
//
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
// 示例 2：
//
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//
// 示例 3：
//
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums 是一个非递减数组
// -109 <= target <= 109
//
// Related Topics 数组 二分查找
public class Code_34 {
    public int[] searchRange2(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int leftNumber=lowerBound(left,right,nums,target);
        int rightNumber=upperBound(left,right,nums,target);
        if (rightNumber<leftNumber){
            return new int[]{-1,-1};
        }
        return new int[]{leftNumber,rightNumber};
    }
    public int lowerBound(int left,int right,int[] nums,int target){
        while (left<=right){
            int mid=left+((right-left)>>1);
            if (target<=nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public int upperBound(int left,int right,int[] nums,int target){
        while (left<=right){
            int mid=left+((right-left)>>1);
            if (target>=nums[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right;
    }
    public int[] searchRange (int[] nums, int target) {
        int upper = upperBound(nums,target);
        int low = lowerBound(nums,target);
        //不存在情况
        if (upper < low) {
            return new int[]{-1,-1};
        }
        return new int[]{low,upper};
    }
    //计算下边界
    int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //这里需要注意，计算mid
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                //当目标值小于等于nums[mid]时，继续在左区间检索，找到第一个数
                right = mid - 1;

            }else if (target > nums[mid]) {
                //目标值大于nums[mid]时，则在右区间继续检索，找到第一个等于目标值的数
                left = mid + 1;

            }
        }
        return left;
    }
    //计算上边界
    int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target >= nums[mid]) {
                left = mid + 1;
            }else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return right;
    }
}
