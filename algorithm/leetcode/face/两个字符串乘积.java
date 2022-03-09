package leetcode.face;

public class 两个字符串乘积 {
    public String multiply(String num1, String num2) {
        int n1 = num1.length()-1;	//从0开始计数，所以用长度减1会方便些
        int n2 = num2.length()-1;
        if(n1<0 || n2<0)
            return "";	//处理输入为空的特殊情况
        if(num1.equals("0") || num2.equals("0"))
            return "0";	//若不加这一块，乘以“0”会出现“0000”这样的结果，而不是“0”
        int[] ans = new int[n1+n2+2];	//两数相乘，长度最长为两数各自长度的乘积
        for(int i = 0;i<n1+1;i++)
            for(int j = 0;j<n2+1;j++ ){
                int n = i + j;
                ans[n] += (num1.charAt(n1-i)-'0')*(num2.charAt(n2-j)-'0');
            }
        /*在字符串中，最左侧为0位，但我们想让最右边为0位，故用n1-i,而不是i*/
        for(int t = 1;t<n1+n2+2;t++){	//这个循环用来处理进位问题
            ans[t] += ans[t-1]/10;
            ans[t-1] = ans[t-1]%10;
        }
        //用len处理可能存在的位于高位的多余的0
        int len = ans[n1+n2+1] == 0?n1+n2:n1+n2+1;
        StringBuilder sb = new StringBuilder();
        for(int i = len; i>-1; i--)
            sb.append(ans[i]);
        return sb.toString();
    }
}
