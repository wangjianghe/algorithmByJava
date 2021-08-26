package leetcode.array;

import java.util.ArrayList;
import java.util.List;

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
