package leetcode.array;

import java.util.Arrays;

/**
 * Partition Array Into Three Parts With Equal Sum
 */
//将数组分为三份，如果三分的和相同返回true 否则false
public class Code_1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();
        // if the total sum doesn't divide into three, return false
        if (sum%3 != 0)
            return false;
        int each = sum/3, temp = 0, found = 0;

        // count parts with right sum
        for (int i=0; i<A.length; i++) {
            temp += A[i];
            if (temp == each) {
                temp = 0;
                found++;
            }
        }
        return found>=3? true : false;
    }
    public static boolean canThreePartsEqualSumTwo(int[] A) {
        int sum=Arrays.stream(A).sum();
        if (sum%3!=0)
            return false;
        int foundNums=0;
        int partSum=0;
        int sumResult=sum/3;
        for (int i=0;i<A.length;i++){
            partSum+=A[i];
            if (partSum==sumResult){
                foundNums++;
                partSum=0;
            }
        }
        return foundNums>=3;
    }

    public static void main(String[] args) {
        int[] a=new int[]{0,2,1,-6,6,-7,9,1,2,0,1};
        canThreePartsEqualSumTwo(a);
    }
}
