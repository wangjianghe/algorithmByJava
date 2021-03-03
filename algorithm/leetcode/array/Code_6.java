package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Code_6 {
    public static void main(String[] args) {
        System.out.println(convert3("PAYPALISHIRING",3));
    }
    public static String convert3(String s, int numRows){
        if (numRows==1){
            return s;
        }
        char[] newArray=new char[s.length()];
        char[] oldArray=s.toCharArray();
        int intervalValue=2*numRows-2;
        int newArrayPos=0;
        int jumpPos;
        for (int i=0;i<numRows;i++){
            jumpPos=0;
            if (i==0||i==numRows-1){
                while (jumpPos+i<s.length()){
                    newArray[newArrayPos++]=oldArray[jumpPos+i];
                    jumpPos+=intervalValue;
                }
            }else{
                while (jumpPos+i<s.length()){
                    newArray[newArrayPos++]=oldArray[jumpPos+i];
                    jumpPos+=intervalValue;
                    if (jumpPos-i<s.length()){
                        newArray[newArrayPos++]=oldArray[jumpPos-i];
                    }
                }
            }
        }
        return new String(newArray);
    }
    /**
     * 不考虑原字符串的顺序，而是考虑结果中每个字符来自何处，于是可以想到，最开始的字符来自第0行，之后依次来自第1，2，3，···，numRows-1行。
     * 然后再看第0行和第numRows-1行的字符，每个之间都间隔2\*numRows-2个字符，如果用i来表示行数，那么他们对2\*numRows-2取余结果是i；其余第i行的字符同样对2\*numRows-2取余结果是i或-i。
     * 于是我们从第0行开始，每行最开始cnt都为0，每隔dx=2\*numRows-2个字符，将字符s[cnt+i]加到结果的尾部，对第numRows-1行也是这样的操作，直到cnt+i >= len为止；
     * 对于中间的第i行，先将s[cnt+i]加到尾部，然后再将cnt加上dx，如果cnt-i < len，则将s[cnt-i]加到尾部，然后进入下一个循环再考虑s[cnt+i]，直到cnt+i >= len。
     * 最后再将结果（字符数组cn）转换为String即可。
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        // 参数初始化
        if (numRows == 1) return s;
        char[] c = s.toCharArray();
        int len = s.length(), dx = 2 * numRows - 2, cnt = 0, pos = 0;
        // cnt对于原字符串中的一组的起点（2*numRows-2一组），cnt+i或cnt-i为第i行的字符
        // pos表示当前新的字符串的尾部在第pos个位置
        char[] cn = new char[len]; // 新的字符数组

        for (int i = 0; i < numRows; ++i) {
            cnt = 0;
            // 第0行和第numRows-1行只有s[cnt+i]会被加入数组
            if (i == 0 || i == numRows-1) {
                while (cnt + i < len) {
                    cn[pos++] = c[cnt+i];
                    cnt += dx;
                }
            }
            // 其他第i行都有s[cnt+i]和s[cnt-i]要考虑，并且必须按顺序加入，还不能越界
            else {
                while (cnt + i < len) {
                    cn[pos++] = c[cnt+i];
                    cnt += dx;
                    if (cnt - i < len) {
                        cn[pos++] = c[cnt-i];
                    }
                }
            }
        }
        // 最终再转换为String，这是减少运行时间的关键
        // 如果一直用result += c[cnt+i]的方法得到结果，运行时间会远大于2ms
        return new String(cn);
    }
    public String convert(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for(int i = 0;i < Math.min(numRows,s.length());i++){//结合实际情况，可能会有row>s.length()和row小于的情况，空间没必要浪费
            list.add(new StringBuilder());
        }
        char[] ch = s.toCharArray();
        int row = 0;
        boolean flag = false;
        for(char c : ch){//这里row可以用二维数组row和col的定位方式来理解，只是list这种方式不用col来定位。
            list.get(row).append(c);
            if(row == 0){
                flag = true;
            }
            if(row == numRows-1){
                flag = false;
            }
            if(flag){
                row++;
            }else{
                row--;
            }
        }
        StringBuilder sB = new StringBuilder();
        for(StringBuilder sb : list){
            sB.append(sb);
        }
        return sB.toString();
    }
}
