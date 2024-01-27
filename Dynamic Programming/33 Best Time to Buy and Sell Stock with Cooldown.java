/* LeetCode
You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. 
You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = -prices[0];
        for(int i = 1; i < n; i++) {
            if(i - 2 >= 0)
                dp[i][0] = Math.max(dp[i - 2][1] - prices[i], dp[i - 1][0]);
            else
                dp[i][0] = Math.max(-prices[1], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][1];
    }
}
