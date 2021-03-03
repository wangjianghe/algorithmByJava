package leetcode.array;
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
public class Code_4 {
    /**
     * 解法1:直接合并数组,然后取平均值
     * 时间复杂度：遍历全部数组 (m+n)
     * 空间复杂度：开辟了一个数组，保存合并后的两个数组 O(m+n)
     * @param nums1
     * @param nums2
     * @return
     */
    /**
     * 解法2:对两个数组进行标记，然后循环(m+n)/2次来找到中未数的值，可以用个值记录前一个的值和当前值
     * 时间复杂度：遍历 len/2+1 次，len=m+n，所以时间复杂度依旧是 O(m+n)。
     * 空间复杂度：我们申请了常数个变量，也就是 m，n，len，left，right，aStart，bStart 以及 i  所以空间复杂度是 O(1）
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0;
        int midIndex=0;
        int leftValue=-1;
        int rightValue=-1;
        int mid=(nums1.length+nums2.length)/2;
        for (;midIndex<=mid;midIndex++){
            leftValue=rightValue;
            if (i<nums1.length&&(j>=nums2.length||nums1[i]<nums2[j])){
                rightValue=nums1[i++];
            }else{
                rightValue=nums2[j++];
            }
        }
        if ((nums1.length+nums2.length)%2==0){
            return (leftValue+rightValue)/2.0;
        }
        return rightValue;
    }

    /**
     * 解法3，进行二分法，将两个数组进行二分 由于数列是有序的，
     * 其实我们完全可以一半儿一半儿的排除。假设我们要找第 `k` 小数，我们可以每次循环排除掉 `k/2` 个数
     * 时间复杂度：每进行一次循环，我们就减少 k/2 个元素，所以时间复杂度是 O(log(k)，而 k=(m+n)/2，所以最终的复杂也就是 O(log(m+n）。
     * 空间复杂度：虽然我们用到了递归，但是可以看到这个递归属于尾递归，所以编译器不需要不停地堆栈，所以空间复杂度为 O(1)。
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }
    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    /**
     * 解法4：
     * 时间复杂度：我们对较短的数组进行了二分查找，所以时间复杂度是 O(log（min（m，n））。
     * 空间复杂度：只有一些固定的变量，和数组长度无关，所以空间复杂度是 O ( 1 )。
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2,nums1); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && nums2[j-1] > nums1[i]){ // i 需要增大
                iMin = i + 1;
            }
            else if (i != 0 && j != n && nums1[i-1] > nums2[j]) { // i 需要减小
                iMax = i - 1;
            }
            else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }



    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays3(new int[]{1,5,6},new int[]{2,3}));;
    }
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int l=nums2.length;
        int left=(n+l+1)/2;
        int right=(n+l+2)/2;
        return (getMidValue(nums1,0,n-1,nums2,0,l-1,left)+getMidValue(nums1,0,n-1,nums2,0,l-1,right))*0.5;
    }
    public static int getMidValue(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int mid){
        int numsLength1=end1-start1+1;
        int numsLength2=end2-start2+1;
        if (numsLength1>numsLength2) return getMidValue(nums2,start2,end2,nums1,start1,end1,mid);
        if (numsLength1==0){
            return nums2[start2+mid-1];
        }
        if (mid==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        int mid1=start1+Math.min(numsLength1,mid/2)-1;
        int mid2=start2+Math.min(numsLength2,mid/2)-1;

        if (nums1[mid1]>nums2[mid2]){
            return getMidValue(nums1,start1,end1,nums2,mid2+1,end2,mid-(mid2-start2+1));
        }else{
            return getMidValue(nums1,mid1+1,end1,nums2,start2,end2,mid-(mid1-start1+1));
        }
    }
}
