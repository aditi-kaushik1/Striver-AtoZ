/* LeetCode
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again). */

class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k + 1];
        for(int i = 0; i < prices.length; i++) {
            for(int j = 0; j < 2; j++) {
                for(int l = 0; l <= k; l++) {
                    dp[i][j][l] = -1000000;
                }
            }
        }
        return helper(0, 0, k, prices, dp);
    }

    private int helper(int index, int toBuy, int k, int[] prices, int[][][] dp) {
        if(k == 0 || index == prices.length)
            return 0;
        if(dp[index][toBuy][k] != -1000000)
            return dp[index][toBuy][k];
        if(toBuy == 0)
            dp[index][toBuy][k] = Math.max(helper(index + 1, 1^toBuy, k, prices, dp) - prices[index], helper(index + 1, toBuy, k, prices, dp));
        else
            dp[index][toBuy][k] = Math.max(helper(index + 1, 1^toBuy, k - 1, prices, dp) + prices[index], helper(index + 1, toBuy, k, prices, dp));
        return dp[index][toBuy][k];
    }
}
