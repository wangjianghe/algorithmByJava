package leetcode.array;

import java.util.Stack;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
public class Code_20 {
    public boolean isValid(String s) {
        char[] chars=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for (char c:chars){
            if (c=='('){
                stack.push(')');
            }else if (c=='{'){
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
            }else if (stack.isEmpty()||stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Code_20 code20=new Code_20();
        System.out.println(code20.isValid("("));;
    }
}
