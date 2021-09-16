package leetcode.array;

import java.util.ArrayList;
import java.util.List;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
public class Code_22 {
    public static void main(String[] args) {
        Code_22 code_22=new Code_22();
        System.out.println(code_22.generateParenthesis(3));
    }
    List<String> outPutList=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        String str="(";
        int left=n-1;
        int right=n;
        setOutPut(str,left,right);
        return outPutList;
    }
    public void setOutPut(String str,int left,int right){
        if (left==0&&right==0){
            outPutList.add(str);
            return;
        }
        if (left<=right){
            if (left>0){
                setOutPut(str+"(",left-1,right);
            }
            setOutPut(str+")",left,right-1);
        }
    }
}
