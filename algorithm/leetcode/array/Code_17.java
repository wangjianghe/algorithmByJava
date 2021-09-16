package leetcode.array;

import java.util.ArrayList;
import java.util.List;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
// Related Topics 深度优先搜索 递归 字符串 回溯算法
//
public class Code_17 {
    String[] phoneMap=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans=new ArrayList<>();
    char[] abc;
    public void dfs(char[] phoneString,int dept,int max){
        if (dept==max){
            StringBuilder result= new StringBuilder();
            for (char c:abc){
                result.append(c);
            }
            ans.add(result.toString());
            return;
        }
        int charLength=phoneMap[phoneString[dept]-'2'].length();
        for (int i=0;i<charLength;i++){
            abc[dept]=phoneMap[phoneString[dept]-'2'].charAt(i);
            dfs(phoneString,dept+1,max);
        }
    }
    public List<String> letterCombinations(String digits) {
        char[] digitChars=digits.toCharArray();
        abc=new char[digitChars.length];
        if (digitChars.length==0){
            return ans;
        }
        dfs(digitChars,0,digits.length());
        return ans;
    }

    public static void main(String[] args) {
        Code_17 code17=new Code_17();
        System.out.println(code17.letterCombinations("23455"));
    }

}
