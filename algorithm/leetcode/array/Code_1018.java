package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个0和1的数组A，考虑N_i：从A[0]到A[i]的第i个子数组，
 * 被解释为二进制数（从最高有效位到最低有效位）
 * 返回布尔型答案的列表，当且仅当N_i可被5整除时，answer[i]为真。
 */

/**
 * 第一次计算，二进制数为1，转为十进制为1，1%5=1。
 * 第二次计算，二进制数为11，转为十进制为3，(1*2+1)%5 = 3%5 =3。
 * 第三次计算，二进制数为111，转为十进制为7，(3*2+1)%5 = 7%5 =2。
 * 第四次计算，二进制数为1110，转为十进制为14，(2*2+0)%5 = 4%5 = 14%5 =4。
 * 第五次计算，二进制数为11101，转为十进制为29，(4*2+1)%5= 9%5 = 29%5 =4。
 * 新的二进制数是在前一次二进制数的基础上左移一位得到的，即 num[i+1] = (A[i]<<1) + A[i+1]，A[i]为前一次的十进制整数，
 * A[i+1]为在前一次二进制数尾部新加的0或1，
 * 题目只是需要我们判断每次新组成的二进制数能否被5整除，我们可以利用前一次取余的结果左移，
 * 因为其中能被整除的部分是不太需要关心的，这样可以避免数字过大超出范围的风险
 */
public class Code_1018 {
    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> answer = new ArrayList<Boolean>();
        int num = 0;
        for (int i=0; i<A.length; i++) {
            //num = (num<<1) + A[i]
            num = num*2 + A[i];
            num %= 5;
            answer.add(num == 0);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(1111%5);
        System.out.println(prefixesDivBy5(new int[]{1,1,1}));
    }
}
