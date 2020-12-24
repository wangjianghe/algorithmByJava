package leetcode.array;

/**
 *
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
