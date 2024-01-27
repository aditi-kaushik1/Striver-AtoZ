/*LeetCode
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). 
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The testcases are generated so that the answer will be less than or equal to 2 * 109. */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] uniqueWays = new int[m][n];
        if(obstacleGrid[0][0] == 1)
            return 0;
        
        for(int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 0)
                uniqueWays[i][0] = 1;
            else
                break;
        }

        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 0)
                uniqueWays[0][i] = 1;
            else
                break;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1)
                    uniqueWays[i][j] = 0;
                else
                    uniqueWays[i][j] = uniqueWays[i - 1][j] + uniqueWays[i][j - 1];
            }
        }
        return uniqueWays[m - 1][n - 1];
    }
}
