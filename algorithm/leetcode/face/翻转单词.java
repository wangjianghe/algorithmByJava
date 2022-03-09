package leetcode.face;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 翻转单词 {
    public String reverseWords(String s) {
        //去除开头和结尾的空格
        s = s.trim();
//正则匹配连续的空白字符作为分隔符分割
        List wordList = Arrays.asList(s.split("\\s+"));
//反转字符串
        Collections.reverse(wordList);
//拼接字符串
        return String.join(" ", wordList);
    }
    public String reverseWords2(String s) {
        if (s.length()==0)return s;//如果为空直接返回
        char strs[]=s.toCharArray(),ans[]=new char[s.length()];//字符串转为char字符数组
        int count=0,j=0;//全局变量j记录新数组索引
        for(int i=s.length()-1;i>=0;i--){//指针i从右向左遍历strs字符
            if(strs[i]==' '){//判断是否为空格字符
                int k=i+1;
                if(count>0){
                    while (--count>=0){//从字符i向右count个字符赋给新数组ans
                        ans[j++]=strs[k++];
                    }
                    ans[j++]=' ';
                    count=0;//count初始化为0
                }
            }else if(i==0){
                for(;i<=count;i++)ans[j++]=strs[i];//左移到第一个字符时证明不是以空格开头，则从0获取count+1个个字符赋给ans
                j+=1;
                break;
            }
            else {
                count++;//如果是字母，则count累加1
            }
        }
        if(j<1)return "";//如果j依然是0，则原字符串全为空格，返回空字符串
        String string=String.valueOf(ans,0,j-1);//char数组转为字符串返回
        return string;
    }
}
