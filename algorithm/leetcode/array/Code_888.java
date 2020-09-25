package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Code_888 {
    /**
     * 两个人之间有一堆糖果，然后糖果的大小不同，最后让两个人手里的糖果质量之和一样
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap1(int[] A, int[] B) {
        int AliceCandySum = 0;
        int BobCandySum = 0;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            AliceCandySum += a;
        }
        for (int b : B) {
            BobCandySum += b;
            set.add(b);
        }
        int detail = (BobCandySum - AliceCandySum) / 2;
        for (int a : A) {
            if (set.contains(a + detail)) {
                return new int[]{a, a + detail};
            }
        }
        return null;
    }
}
