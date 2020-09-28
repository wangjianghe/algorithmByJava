package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一个圆盘分为n份，按照逆时针旋转，按照rounds的路线搜索出经过最多的区域
 *
 */
public class Code_1560 {
    public static List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n+1];
        for (int i = 1; i < rounds.length; i++) {
            int end=rounds[i];
            int k=rounds[i-1];
            while(k!=end){
                arr[k%(n+1)]++;
                k++;
                if (k%(n+1)==0){
                    k=1;
                }
            }
        }
        arr[rounds[rounds.length-1]]++;
        int[] copyArray=arr.clone();
        Arrays.sort(copyArray);
        for (int i=0;i<arr.length;i++){
            if (arr[i]==copyArray[arr.length-1]){
                list.add(i);
            }
        }
        return list;
    }
    public static List<Integer> mostVisitedThree(int n, int[] rounds){
        List<Integer> arrayList=new ArrayList<>();
        int size=rounds.length-1;
        if (rounds[0]<=rounds[size]){
            for (int i=rounds[0];i<=rounds[size];i++){
                arrayList.add(i);
            }
        }else{
            for (int i=1;i<=rounds[size];i++){
                arrayList.add(i);
            }
            for (int i=rounds[0];i<=n;i++){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
    public static List<Integer> mostVisitedTwo(int n, int[] rounds){
        List<Integer> al=new ArrayList();
        int[] frequency=new int[n+1];
        for(int i=1;i<rounds.length;i++){
            int j=rounds[i-1];
            if(j%(n+1) == 0) j=1;
            while((j%(n+1))!=rounds[i]){
                frequency[j%(n+1)]++;
                j++;
                if(j%(n+1) == 0) j=1;
            }
        }
        int j=rounds[rounds.length-1]%(n+1);
        if(j==0) j=1;
        frequency[j]++;
        int fmax=getMax(frequency);
        for(int i=0;i<frequency.length;i++){
            if(frequency[i]==fmax)
                al.add(i);
        }
        return al;
    }
    public static int getMax(int[] arr){
        int max=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max) max=arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,3,1,2};
        System.out.println(mostVisited(4,array));
    }
}
