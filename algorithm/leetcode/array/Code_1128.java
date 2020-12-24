package leetcode.array;

import java.util.Arrays;

/**
 * Number of Equivalent Domino Pairs 等效多米诺对数
 * 给定一个多米诺骨牌列表，多米诺骨牌[i]=[a，b]等同于多米诺骨牌[j]=[c，d]
 * 当且仅当（a==c和b==d）或（a==d和b==c）-也就是说，一个多米诺骨牌可以旋转成与另一个多米诺骨牌相等。
 * 返回0<=i<j<多米诺骨牌长度，而多米诺骨牌[i]相当于多米诺骨牌[j]。
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 */
public class Code_1128 {
    private int uniqueKey(int a, int b) {
        return a < b ? a * 10 + b : b * 10 + a;
    }

    public int numEquivDominoPairsTwo(int[][] dominoes) {
        int[] countByKey = new int[1000];
        int result = 0;
        for(int[] domino: dominoes) {
            int key = uniqueKey(domino[0], domino[1]);
            result += countByKey[key]++;
        }
        return result;
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        //Store the length of the array in a variable to save time accessing it every time:
        int n = dominoes.length;
        //Count the number of pairs
        int count = 0;

        int[] moreEfficientHashMap = new int[89];

        for(int i = 0; i < n; i++) {
            int[] pair = dominoes[i];
            //Sort the pair. E.g. [2,1] -> [1,2]
            Arrays.sort(pair);

            //Get the index number. E.g. [1,2] -> 12
            int s = pair[0]*10 + pair[1];
            //Increase the number of pairs found for the specific element,
            int k = moreEfficientHashMap[s-11] + 1;

            if(k>1) {
                //Add to the count the previous pairs that we found
                count+= k - 1;
            }
            //Set the the pair to be equals to the number of counts
            moreEfficientHashMap[s-11] = k;
        }
        //Return the number of pairs
        return count;
    }
    public static void main(String[] args) {

    }
}
