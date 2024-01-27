/* Problem statement
Ninja is planing this ‘N’ days-long training schedule. 
Each day, he can perform any one of these three activities. 
(Running, Fighting Practice or Learning New Moves). 
Each activity has some merit points on each day. As Ninja has to improve all his skills, 
he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?
You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. 
Your task is to calculate the maximum number of merit points that Ninja can earn. */

public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int[][] ans = new int[n][3];

        for(int i = 0; i < 3; i++)
            ans[0][i] = points[0][i];
        
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                ans[i][j] = Math.max(ans[i - 1][(j + 1)% 3], ans[i - 1][(j + 2) % 3]) + points[i][j];
                if(i == (n - 1))
                    max = Math.max(max, ans[i][j]);
            }
        }
        return max;
    }
}
