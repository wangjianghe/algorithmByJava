package leetcode.array;

import java.util.Arrays;

public class Code_167 {
    public static int[] twoSum(int[] numbers, int target) {
        int startNumber=0;
        int endNumber=numbers.length-1;
        while (startNumber<endNumber){
            int resultTarget=numbers[startNumber]+numbers[endNumber];
            if (resultTarget>target){
                endNumber--;
            }else if (resultTarget<target){
                startNumber++;
            }else{
                return new int[]{startNumber+1,endNumber+1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-1,0}, -1)));
    }
}
