package leetcode.array;

/**
 *  Check If It Is a Straight Line 给与一个二维数组，查看是否能在平面上形成一条直线
 *  数学1：两个点之间的斜率  k=(y2-y1)/(x2-x1)
 */
public class Code_1232 {
    public static boolean checkStraightLine(int[][] coordinates) {

        int points = coordinates.length;

        int x = coordinates[1][0] - coordinates[0][0];
        int y = coordinates[1][1] - coordinates[0][1];

        int curr_x = 0, curr_y = 0;

        for(int i=2;i<points;i++)
        {
            curr_x = coordinates[i][0] - coordinates[i-1][0];
            curr_y = coordinates[i][1] - coordinates[i-1][1];

            if(y*curr_x != x*curr_y)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
