package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();
        Arrays.sort(nums);
        int numFlag=1;
        for (int num : nums) {
            if (numFlag < num) {
                for (int k = numFlag; k < num; k++) {
                    result.add(k);
                }
                numFlag = num;
            }
            if (numFlag == num) {
                numFlag++;
            }
        }
        for (;numFlag<=nums.length;numFlag++){
            result.add(numFlag);
        }
        return result;
    }

    /**
     * 运用额外的空间
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbersTwo(int[] nums){
        List<Integer> result = new ArrayList<>();
        int max = nums.length;
        for (int i = 0; i < nums.length; i ++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int[] existNumber = new int[max];
        for (int i = 0; i < nums.length; i ++) {
            int location = nums[i];
            existNumber[location - 1] = 1;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (existNumber[i] != 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{5,3,3,3,1}));
    }
}
