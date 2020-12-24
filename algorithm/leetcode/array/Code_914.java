package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一副牌中，每张牌上都写有一个整数。
 *当且仅当您可以选择X>=2，以便可以将整个牌组拆分为1个或多个卡组时，返回true，其中：
 *每组有X张牌。
 *每组中的所有卡片都有相同的整数。
 * 提示：由于 存在 1，1，2，2，2，2可以的情况，所以计算是需要计算的是数量的最大公约数(gcd)
 */
public class Code_914 {
    public static boolean hasGroupsSizeXTwo(int[] deck){
        int prevgcd=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int ele:deck) map.put(ele,map.getOrDefault(ele,0)+1);
        for(int ele:map.values()) prevgcd = gcd(prevgcd,ele);
        return prevgcd>=2;
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }

        return g >= 2;
    }

    public static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }



    public static void main(String[] args) {
        int[] deckArray=new int[]{1,1,2,2,2,2};
        System.out.println(hasGroupsSizeXTwo(deckArray));
    }
}
