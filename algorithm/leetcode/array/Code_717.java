package leetcode.array;

/**
 * 1-bit and 2-bit Characters
 * 一个数组由0和1组成，但是数据能以3种形式存在，0，11，10， 如果这个数组最后一个为0，返回true
 */
public class Code_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        int i = 0;
        while(i < len-1) {
            if(bits[i] == 0) {
                if(i+1 < len) i++;
                else break;
            }
            else {
                if (i+2 < len) i += 2;
                else break;
            }
        }
        if(i == len || (i == len-1 && bits[len-1] == 0)) return true;
        else return false;
    }
}
