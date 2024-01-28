//Bottom up
// import java.util.* ;
// import java.io.*; 

// public class Solution{
//     static int knapsack(int[] weight, int[] value, int n, int W) {
//         int[][] dp = new int[n + 1][W + 1];
//         for(int i = 1; i <= n; i++) {
//             for(int j = 1; j <= W; j++) {
//                 if(weight[i - 1] <= j)
//                     dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
//                 else
//                     dp[i][j] = dp[i - 1][j];
//             }
//         }
//         return dp[n][W];
//     }
// }

//Top down approach
import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= maxWeight; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(weight, value, 0, maxWeight, dp);
    }

    private static int helper(int[] wt, int[] val, int i, int W, int[][] dp) {
        if(i == wt.length)
            return 0;
        if(dp[i][W] != -1)
            return dp[i][W];
        if(wt[i] <= W)
            dp[i][W] = Math.max(helper(wt, val, i + 1, W, dp), val[i] + helper(wt, val, i + 1, W - wt[i], dp));
        else
            dp[i][W] = helper(wt, val, i + 1, W, dp);
        return dp[i][W];
    }
}
