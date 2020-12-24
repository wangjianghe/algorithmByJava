package leetcode.array;

/**
 * 给定一个包含n个整数的数组，找到给定长度k的具有最大平均值的连续子数组。 并且您需要输出最大平均值。
 * (找出最大平均数)
 */
public class Code_643 {
    public static double findMaxAverage(int[] nums, int k) {
        double totalSum = 0;
        for (int i = 0; i < k; i++) {
            totalSum += nums[i];
        }
        double maxVag = totalSum /k;
        double avg;
        int start = 0;
        for (int i = k; i < nums.length; i++) {
            totalSum=totalSum-nums[start]+nums[i];
            avg = totalSum/k;
            if (avg > maxVag) {
                maxVag = avg;
            }
            start++;
        }
        return maxVag;
    }
    public static double findMaxAverageTwo(int nums[],int k){
        double sum=0;
        for(int i=0;i<k;i++)
            sum+=nums[i];
        double res=sum;
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
            res=Math.max(res,sum);
        }
        return res/k;
    }

    public static void main(String[] args) {
        int[] params=new int[]{4,2,1,3,3};
        System.out.println(findMaxAverage(params,2));
    }
}
