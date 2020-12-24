package leetcode.array;

/**
 *  Can Place Flowers
 *  假设你有一个很长的花坛，其中有些是种的，有些是不种的。
 *  然而，鲜花不能种植在相邻的地块上——它们会争夺水源，两个都会死去。
 * 给定一个花坛（用一个包含0和1的数组表示，其中0表示空，1表示不空）和一个数字n，
 * 如果可以在其中种植n朵新花而不违反“无相邻花”规则，则返回。
 */
public class Code_605 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n==0){
            return true;
        }
        int count=0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i]==1){
                continue;
            }
            int left=i-1;
            int right=i+1;
            int leftValue;
            int rightValue;
            if (left<0){
                leftValue=0;
            }else{
                leftValue=flowerbed[left];
            }
            if (right>flowerbed.length-1){
                rightValue=0;
            }else{
                rightValue=flowerbed[right];
            }
            if (leftValue==rightValue&&leftValue==0){
                count++;
                flowerbed[i]=1;
            }
            if (count>=n){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] flowerbedArray=new int[]{1};
        canPlaceFlowers(flowerbedArray,0);
    }
}
