package leetcode.array;

public class Code_10 {
    public boolean isMatchChar(char[] s, int s1, char[] p, int p1) {
        if(p1 >= p.length) return s1 >= s.length;
        boolean match = s1 < s.length && ((s[s1] == p[p1]) || p[p1] == '.');
        if(p.length - p1 >= 2 && p[p1 + 1] == '*')
            return isMatchChar(s, s1, p, p1 + 2) || (match && isMatchChar(s, s1 + 1, p, p1));
        return match && isMatchChar(s, s1 + 1, p, p1 + 1);
    }
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray(), pp = p.toCharArray();
        return isMatchChar(ss, 0, pp, 0);
    }
}
