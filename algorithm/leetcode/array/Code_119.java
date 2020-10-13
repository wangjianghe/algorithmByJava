package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**  118 的变形，只返回最后一行的数据
 * Pascal's Triangle II
 */
public class Code_119 {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> resultList=new ArrayList<>();
        List<Integer> preList;
        for (int i=1;i<=rowIndex+1;i++){
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
        return resultList.get(resultList.size()-1);
    }

    public static List<Integer> getRowTwo(int rowIndex){
        List l= new ArrayList<>();
        int i,j;
        int dp[][]=new int[rowIndex+1][rowIndex+1]; //declaring dp array for pascals numbers
        if(rowIndex==0){
            l.add(1);
            return l;
        }
        if(rowIndex==1){
            l.add(1);
            l.add(1);
            return l;
        }
        dp[0][0]=1;
        dp[1][0]=1;
        dp[1][1]=1;
        for(i=2;i <= rowIndex;i++){
            dp[i][0]=1;//the first term is 1
            dp[i][i]=1;//the last term is 1
            for(j=1;j < i;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }
        for(i=0; i < rowIndex+1;i++){
            l.add(dp[rowIndex][i]);
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(getRowTwo(4));;
    }
}
