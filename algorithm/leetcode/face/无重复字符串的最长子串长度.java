package leetcode.face;

import java.util.HashMap;

public class 无重复字符串的最长子串长度 {
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();
        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            //ascii码表中的值相同时则说明字符重新出现
            int index = s.charAt(i);
            //last[index]+1表示从下一位数开始
            start = Math.max(start, last[index] + 1);
            //i - start + 1,当前长度
            res   = Math.max(res, i - start + 1);
            //对应ascii码值赋予位置值
            last[index] = i;
        }
        return res;
    }
    public int lengthOfLongestSubstring2(String s) {
        //长度为0直接返回0
        if(s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0;i<s.length();i++){
            //map如果存在对应的键，则说明字符串中有重复，将左边的长度计算出，取最大值
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            //不包含则继续加入map中
            map.put(s.charAt(i),i);
            //从重复字符开始重新计算长度，与上一次长度比较取最大值
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
