package leetcode.array;

/**
 * 您将得到一个整数n。长度为n+1的数组nums按以下方式生成：
 * nums[0]=0
 * nums[1]=1
 * nums[2*i]=nums[i]，当2<=2*i<=n
 * nums[2*i+1]=nums[i]+nums[i+1] 当2<=2*i+1<=n时
 * 返回数组nums中的最大整数。
 * 0 <= n <= 100
 */
public class Code_1646 {
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int[] nums = new int[n+1];
        nums[1]=1;
        int maxNum=0;
        for(int i=2; i<=n; i++){
            nums[i]= i%2==0?nums[i/2]:nums[i/2]+nums[i/2+1];
            maxNum= Math.max(nums[i], maxNum);
        }
        return maxNum;
    }
}
