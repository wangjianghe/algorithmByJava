package leetcode.array;

/**
 * 在给定的整数数组nums中，总是恰好有一个最大的元素。
 *
 * 查找数组中最大的元素是否至少是数组中其他每个数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 * 1.思路1：找到最大数，然后和其他数据比较,判断是否是2倍
 * 2 思路2：找到第一和第二大的数，然后看最大的是否是第二大的二倍
 */
public class Code_747 {
    public static int dominantIndex(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        int largest=-1;
        int second=-1;
        int index=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]>largest){
                second=largest;
                largest=nums[i];
                index=i;
            }else if (nums[i]>second){
                second=nums[i];
            }
        }
        return second*2>largest?-1:index;
    }

    public static void main(String[] args) {
        System.out.println( dominantIndex(new int[]{1,0}));;
    }
}
