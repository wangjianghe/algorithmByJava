package leetcode.array;

import java.util.Arrays;

public class Code_283 {
    /**
     * 将0移动到末尾
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums.length<2){
            return;
        }
        int j=nums.length-1;
        int zeroNums=0;
        int swapSign=-1;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                zeroNums+=1;
                if (swapSign==-1){
                    swapSign=i;
                }
                continue;
            }
            if (swapSign!=-1&&swapSign!=i){
                nums[swapSign]=nums[i];
                swapSign=swapSign+1;
            }
        }
        for (int i=0;i<zeroNums;i++){
            nums[nums.length-i-1]=0;
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{0,1,0,3,12};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
