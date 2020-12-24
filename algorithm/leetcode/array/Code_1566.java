package leetcode.array;

/**
 *  给定正整数arr的数组，请找到长度为m的一组数据，该组数据连续重复k次或更多次。
 *
 * 模式是由一个或多个值组成的子数组（连续的子序列），它们连续重复多次而没有重叠。 模式由其长度和重复次数定义。
 *
 *  如果存在长度为m的模式且重复了k次或更多次，则返回true，否则返回false。
 */
public class Code_1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        if (m * k > n)
            return false;
        int l = 0, r = m;
        int reqLen = 0;
        while (r < n) {
            if (arr[l] == arr[r])
                reqLen++;
            else
                reqLen = 0;
            if (reqLen >= m * (k - 1))
                return true;
            l++;
            r++;
        }
        return false;
    }

    public static boolean containsPatternTwo(int[] arr, int m, int k) {
        if (m*k>arr.length){
            return false;
        }
        int start=0;
        int sequence = 0;
        int secondStart=m;
        while (secondStart<arr.length){
            if (arr[start]==arr[secondStart]){
                sequence++;
            }else{
                sequence=0;
            }
            if (sequence>=m*(k-1)){
                return true;
            }
            start++;
            secondStart++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsPatternTwo(new int[]{1,2,1,2,1,3},2,3));
    }
}
