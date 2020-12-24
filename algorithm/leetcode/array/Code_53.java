package leetcode.array;

/**
 * Maximum Subarray 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Code_53 {
    /**
     * 暴力求解
     */
    public static int maxSubArrayTwo(int[] nums){
        int finalmaxSum=nums[0];
        for (int i=0;i<nums.length;i++){
            int addValue=0;
            for (int j=i;j<nums.length;j++){
                addValue+=nums[j];
                if (addValue>finalmaxSum){
                    finalmaxSum=addValue;
                }
            }
        }
        return finalmaxSum;
    }
    /**
     * 递归
     */
    public static int maxSubArrayThree(int[] nums){
        int finalMaxSum=nums[0];
        for (int i=0;i<nums.length;i++){
            int max=curMaxSub(nums,i);
            if (max>finalMaxSum){
                finalMaxSum=max;
            }
        }
        return finalMaxSum;
    }
    private static int curMaxSub(int[] nums,int index){
        if (index==0){
            return nums[0];
        }
        int pre=curMaxSub(nums,index-1);
        return Math.max(nums[index],nums[index]+pre);
    }

    /**
     * 分而治之
     * @param nums
     * @return
     */
    public static int maxSubArrayFour(int[] nums){
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        return device(nums,0,nums.length-1);
    }
    public static int device(int[] nums,int left,int right){
        if (left>right){
            return Integer.MIN_VALUE;
        }
        if (left==right){
            return nums[left];
        }
        int mid=(left+right)/2;
        int leftValue=device(nums,left,mid-1);
        int rightValue=device(nums,mid+1,right);
        int t=nums[mid];
        int max_num=nums[mid];
        for (int i=mid-1;i>=left;i--){
            t+=nums[i];
            max_num=Math.max(max_num,t);
        }
        t=max_num;
        for (int i=mid+1;i<=right;i++){
            t+=nums[i];
            max_num=Math.max(max_num,t);
        }
        return Math.max(Math.max(leftValue,rightValue),max_num);
    }
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        //Kadane's Algorithm
        //O(n)
        if(nums.length <1) return 0;
        int finalmaxSum = nums[0];
        int currentMaxSum[] = new int[nums.length];

        currentMaxSum[0] = nums[0];

        for(int i=1;i<nums.length;i++) {
            currentMaxSum[i] = Math.max(nums[i],nums[i]+currentMaxSum[i-1]);
            if (finalmaxSum<currentMaxSum[i]){
                finalmaxSum=currentMaxSum[i];
            }
        }
        return finalmaxSum;
    }

    public static void main(String[] args) {
        int[] a=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] a2=new int[]{-2,1};
        System.out.println(maxSubArrayFour(a));
        System.out.println(maxSubArrayTwo(a2));
    }
}
