package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Plus One 把int[] 看作一个值，然后加一
 */
public class Code_66 {
    public static int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int i = digits.length;
        int preValue=1;
        int value = digits[i - 1] + 1;
        if (value < 10) {
            digits[i - 1] = value;
            return digits;
        }
        while (--i >= 0) {
            value=digits[i]+1;
            digits[i] = value % 10;
            preValue = value / 10;
            if (preValue == 0) {
                return digits;
            }
        }
        if (preValue>0){
            int[] arr=new int[digits.length+1];
            System.arraycopy(digits,0,arr,1,digits.length);
            arr[0]=1;
            return arr;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9,9})));
    }
}
