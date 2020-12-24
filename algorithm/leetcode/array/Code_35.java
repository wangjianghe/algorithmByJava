package leetcode.array;

/**
 * 给定一个由不同整数和目标值组成的排序数组，如果找到目标，则返回索引。 如果不是，则返回按顺序插入索引的位置的索引。
 */
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
}
