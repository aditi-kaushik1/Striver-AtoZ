/* LeetCode
You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
Note:
You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
The transaction fee is only charged once for each stock purchase and sale. */

//Method 1
// class Solution {
//     public int maxProfit(int[] prices, int fee) {
//         int n = prices.length;
//         int[][] dp = new int[n][2];

//         dp[0][0] = -prices[0];
//         for(int i = 1; i < n; i++) {
//             dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
//             dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
//         }
//         return dp[n - 1][1];
//     }
// }

//Space optimisation
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int bought = -prices[0];
        int sold = 0;

        for(int i = 1; i < n; i++) {
          //Here the order of bought and sold variables don't matter.
            bought = Math.max(sold - prices[i], bought);
            sold = Math.max(bought + prices[i] - fee, sold);
        }
        return sold;
    }
}
