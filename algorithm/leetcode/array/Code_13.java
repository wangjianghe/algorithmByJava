package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class Code_13 {
    static int[] val = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    static String[] str = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public int romanToInt(String s) {
        int pre=getValue(s.charAt(0));
        int sum=0;
        for (int i=1;i<s.length();i++){
            int num=getValue(s.charAt(i));
            if (pre>=num){
                sum+=pre;
            }else{
                sum-=pre;
            }
            pre=num;
        }
        sum+=pre;
        return sum;
    }
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
