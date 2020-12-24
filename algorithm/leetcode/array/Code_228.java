package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Code_228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> resultList=new ArrayList<>();
        if (nums.length==1){
            resultList.add(nums[0]+"");
            return resultList;
        }
        int i=0;
        int rangeStart=0;
        while (i<nums.length){
            while (i+1<nums.length&&(nums[i+1]-nums[i]==1)){
                i++;
            }
            String result=buildRangeString(nums[rangeStart],nums[i]);
            resultList.add(result);
            i++;
            rangeStart=i;
        }
        return resultList;
    }
    public static String buildRangeString(int start,int end){
        if (start!=end){
            return start+"->"+end;
        }
        return end+"";
    }

    public static void main(String[] args) {
        int[] ints=new int[]{-1};
        System.out.println(summaryRanges(ints));
    }
}
