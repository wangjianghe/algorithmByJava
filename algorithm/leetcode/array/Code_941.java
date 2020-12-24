package leetcode.array;

/**
 * Valid Mountain Array
 * 给定一个整数数组arr，当且仅当它是有效的山数组时返回true。
 * 回想一下，arr是一个山脉阵列，当且仅当：
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < A[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 */
public class Code_941 {
    public boolean validMountainArray(int[] arr) {
        int N = arr.length;
        int i = 0;
        while (i + 1 < N && arr[i] < arr[i + 1])
            i++;
        if (i == 0 || i == N - 1)
            return false;
        while (i + 1 < N && arr[i] > arr[i + 1])
            i++;
        return i == N - 1;
    }
}
