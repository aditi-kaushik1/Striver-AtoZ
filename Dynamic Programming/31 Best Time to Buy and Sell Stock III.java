/* LeetCode
You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again). */

class Solution {
    public int maxProfit(int[] prices) {
        int K = 2;
        int[][][] dp = new int[prices.length][2][K + 1];
        for(int i = 0; i < prices.length; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k <= K; k++) {
                    dp[i][j][k] = -2000000;
                }
            }
        }
        return helper(0, 0, 0, prices, dp, K);
    }

    private int helper(int index, int toBuy, int times, int[] prices, int[][][] dp, int maxTimes) {
        if(index == prices.length || times == maxTimes)
            return 0;
        if(dp[index][toBuy][times] != -2000000)
            return dp[index][toBuy][times];
        if(toBuy == 0)
            dp[index][toBuy][times] = Math.max(helper(index + 1, 1^toBuy, times, prices, dp, maxTimes) - prices[index], helper(index + 1, toBuy, times, prices, dp, maxTimes));
        else
            dp[index][toBuy][times] = Math.max(helper(index + 1, 1^toBuy, times + 1, prices, dp, maxTimes) + prices[index], helper(index + 1, toBuy, times, prices, dp, maxTimes));
        return dp[index][toBuy][times];
    }
}
