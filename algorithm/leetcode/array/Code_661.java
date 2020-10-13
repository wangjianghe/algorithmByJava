package leetcode.array;

import java.util.Arrays;

/**
 * Image Smoother
 *
 *统计二维素组的周围包括只身的和的平均值
 */
public class Code_661 {
    public int[][] imageSmoother(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                int count = 0;
                for (int nr = r-1; nr <= r+1; ++nr)
                    for (int nc = c-1; nc <= c+1; ++nc) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                ans[r][c] /= count;
            }
        return ans;
    }

    public static int[][] imageSmootherTwo(int[][] M) {
        int row=M[0].length;
        int column=M.length;
        int[][] ans=new int[column][row];
        for (int i=0;i<column;i++){
            for (int k=0;k<row;k++){
                int startColumn= Math.max(i - 1, 0);
                int endColumn=Math.min(i+2,column);
                int startRow=Math.max(k-1,0);
                int endRow=Math.min(k+2,row);
                int count=0;
                for (;startColumn<endColumn;startColumn++){
                    for (int startK=startRow;startK<endRow;startK++){
                        count++;
                        ans[i][k]+=M[startColumn][startK];
                    }
                }
                ans[i][k]/=count;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arrays=new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        arrays=imageSmootherTwo(arrays);
        for (int i=0;i<arrays.length;i++){
            for (int k=0;k<arrays[0].length;k++){
                System.out.print(arrays[i][k]+" ");
            }
            System.out.println();
        }

    }
}
