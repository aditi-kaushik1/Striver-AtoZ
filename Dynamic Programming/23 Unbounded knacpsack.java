//Bottom up approach
public class Solution {
    public static int unboundedKnapsack(int n, int W, int[] profit, int[] wt) {
        int[][] dp = new int[n + 1][W + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= W; j++) {
                if(wt[i - 1] <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], profit[i - 1] + dp[i][j - wt[i - 1]]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];
    }
}

//Top down approach
// public class Solution {
//     public static int unboundedKnapsack(int n, int W, int[] profit, int[] wt) {
//         int[][] dp = new int[n][W + 1];
//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j <= W; j++) {
//                 dp[i][j] = -1;
//             }
//         }
//         return helper(0, W, profit, wt, dp);
//     }

//     private static int helper(int i, int W, int[] profit, int[] wt, int[][] dp) {
//         if(i == wt.length)
//             return 0;
//         if(dp[i][W] != -1)
//             return dp[i][W];
//         if(wt[i] <= W)
//             dp[i][W] = Math.max(helper(i + 1, W, profit, wt, dp), profit[i] + helper(i, W - wt[i], profit, wt, dp));
//         else
//             dp[i][W] = helper(i + 1, W, profit, wt, dp);
//         return dp[i][W];
//     }
// }
