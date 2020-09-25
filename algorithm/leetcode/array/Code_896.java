package leetcode.array;

import com.sun.org.apache.bcel.internal.generic.IFGE;

/**
 * 如果数组是单调递增或者单调递减（单调函数）
 */
public class Code_896 {
    public static boolean isMonotonic(int[] A) {
        if (A.length==1){
            return true;
        }
        if(A[0]>=A[A.length-1]){
            for (int i=0;i<A.length-1;i++){
                if(A[i]<A[i+1]){
                    return false;
                }
            }
        }else{
            for (int i=0;i<A.length-1;i++){
                if(A[i]>A[i+1]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{4,3,2}));
    }
}
