package leetcode.face;

public class 字符串数组中的最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        int len = strs.length, min_val = Integer.MAX_VALUE;

        //查找最短的字符串的长度，为了避免越界访问
        for(int i = 0; i < len; ++i)
        {
            min_val = Math.min(strs[i].length(), min_val);
        }

        //以第一个字符串为基准，按个字母与所有字符串比较，一旦不一样结果也就出来了
        int nSize = strs.length;
        String ret = "";
        for(int i=0; i<min_val; i++)
        {
            for(int j=1; j<nSize; j++)
            {
                if(strs[0].charAt(i) != strs[j].charAt(i))
                    return ret;
            }
            ret += strs[0].charAt(i);
        }
        return ret;
    }
}
