package leetcode.array;

/**
 * 数组中为股票价格，然后进行买卖计算出最大利润
 */
public class Code_122 {
    public int maxProfit(int[] prices) {
        int maxProfile=0;
        for (int i=1;i<prices.length;i++){
            if (prices[i]>prices[i-1]){
                maxProfile+=prices[i]-prices[i-1];
            }
        }
        return maxProfile;
    }
}
