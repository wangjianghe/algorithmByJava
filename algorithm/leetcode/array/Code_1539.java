package leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Kth Missing Positive Number
 *  统计在 array中没有得数得 第k个，数组是从小到大得
 */
public class Code_1539 {
    public static int findKthPositive(int[] arr, int k) {
        int arrayEnd=arr[arr.length-1];
        int markPoint;
        int val=arrayEnd-arr.length;
        if (val<k){
            int result=arrayEnd;
            markPoint=arrayEnd-arr.length;
            while (markPoint!=k){
                markPoint++;
                result++;
            }
            return result;
        }
        int disparityNums=0;
        int nums=0;
        for(int i=0;i<arr.length;i++){
            nums+=arr[i]-disparityNums-1;
            disparityNums=arr[i];
            if (nums>=k){
                int resultValue=arr[i]-1;
                while (nums!=k){
                    nums--;
                    resultValue-=1;
                }
                return resultValue;
            }
        }
        return 0;
    }

    /**
     * 不考虑效率
     * @param arr
     * @param k
     * @return
     */
    public static int findKthPositiveTwo(int[] arr, int k) {
        int arrayEnd=arr[arr.length-1];
        List<Integer> arrList= Arrays.stream(arr).boxed().collect(Collectors.toList());
        int mark=0;
        int result=0;
        if (arrayEnd-arr.length<k){
            mark=arrayEnd-arr.length;
            result=arrayEnd;
            while (mark!=k){
                mark++;
                result++;
            }
            return result;
        }
        for (int i=1;i<=arrayEnd;i++){
               if (!arrList.contains(i)){
                   mark++;
                   result=i;
               }
               if (mark==k){
                   return result;
               }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(findKthPositiveTwo(new int[]{1,2,3,4},2));
    }
}
