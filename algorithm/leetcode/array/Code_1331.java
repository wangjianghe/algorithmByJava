package leetcode.array;

import java.util.*;

/**
 * 给一个数组，按照顺序返回他们的排名，如果数值相同则排名一致
 */
public class Code_1331 {
    /**超时
     * @param arr
     * @return
     */
    public static int[] arrayRankTransform(int[] arr) {
        Set<Integer> set=new LinkedHashSet<>();
        for (int a:arr){
            set.add(a);
        }
        int[] setArray=new int[set.size()];
        int sign=0;
        Iterator<Integer> integerIterator=set.iterator();
        while (integerIterator.hasNext()){
            setArray[sign++]=integerIterator.next();
        }
        Arrays.sort(setArray);
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<setArray.length;j++){
                if (arr[i]==setArray[j]){
                    arr[i]=j+1;
                    break;
                }
            }
        }
        return arr;
    }

    public static int[] arrayRankTransformTwo(int[] arr) {
        int[] clone=arr.clone();
        Arrays.sort(clone);
        int rank=1;
        Map<Integer,Integer> map=new HashMap<>();
        for (int a:clone){
            if (map.get(a)==null){
                map.put(a,rank);
                rank++;
            }
        }
        for (int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{2,-11,24,15,26,-31,-48,-49,22,37,-36})));
    }
}
