package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数numRows，生成Pascal三角形的第一个numRows。
 */
public class Code_118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList=new ArrayList<>();
        List<Integer> preList;
        for (int i=1;i<=numRows;i++){
            List<Integer> result=new ArrayList<>();
            for (int k=1;k<=i;k++){
                if (k==i){
                    result.add(1);
                    resultList.add(result);
                    continue;
                }
                if (k==1){
                    result.add(1);
                    continue;
                }
                int pre=k-1;
                preList=resultList.get(i-2);
                int currentValue=preList.get(pre-1)+preList.get(pre);
                result.add(currentValue);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
