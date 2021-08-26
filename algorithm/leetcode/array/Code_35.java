package leetcode.array;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// 👍 876 👎 0
public class Code_35 {

    public int searchInsert(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            if (nums[i]==target){
                return i;
            }
            if (nums[i]>target){
                return i;
            }
        }
        return nums.length;
    }
    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n;  //右边界不能取到：[0, n)
        while(l < r){  //由于右边界无法取到，所以当l < r时l已达到区间内最右元素
            //本写法可以避免溢出
            int mid = l + (r - l) / 2;
            //找到返回
            if(target == nums[mid]) return mid;
                //减治
            else if(target < nums[mid]) r = mid;  //右边界不能取到：[0, n)
            else l = mid + 1;
        }
        return l;
    }
    public int searchInsert3(int[] nums, int target) {
        int n = nums.length;
        return search(nums, target, 0, n - 1);//右边界可以取到：[0,n]
    }

    public int search(int[] nums, int target, int l, int r){
        if(l >= r) return l;  //右边界可以取到，所以当l = r时才l才指向区间内最右元素
        int mid = (l + r) / 2;  //本写法无法防止溢出
        if(target < nums[mid]) return search(nums, target, l, mid - 1);  //右边界可以取到：[0,n]
        if(target > nums[mid]) return search(nums, target, mid + 1, r);
        return mid;
    }
}
