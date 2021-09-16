package leetcode.array;

//实现 strStr() 函数。
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。
//// Related Topics 双指针 字符串
public class Code_28 {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)){
            return 0;
        }
        if (needle.length()>haystack.length()){
            return -1;
        }
        for (int i=0;i<haystack.length();i++){
            if (haystack.charAt(i)==needle.charAt(0)){
                int j=1;
                for (;j<needle.length()&&(i+j)<haystack.length();j++){
                    if (haystack.charAt(i+j)!=needle.charAt(j)){
                        break;
                    }
                }
                if (j==needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Code_28 code_28=new Code_28();
        System.out.println(code_28.strStr("mississippi","issipi"));
    }
}
