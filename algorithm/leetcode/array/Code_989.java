package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 将A+K的值用list的形式展示出来
 */
public class Code_989 {
    public static List<Integer> addToArrayForm(int[] A, int K) {

        List<Integer> list=new ArrayList<>();
        int i=A.length;
        while (--i>=0||K>0){
            if (i>=0){
                K+=A[i];
            }
            list.add(K%10);
            K=K/10;
        }
        Collections.reverse(list);
        return list;
    }

    public static List<Integer> addToArrayFormTwo(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(addToArrayFormTwo(new int[]{2,0,6,8,9,3},237));
    }
}
