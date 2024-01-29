/* LeetCode
Given a string s, find the longest palindromic subsequence's length in s.
A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements. */

//Bottom up approach
class Solution {
    public int longestPalindromeSubseq(String s) {
        String sReverse = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n][n];
        boolean isCommon = false;
        for(int i = 0; i < n; i++) {
            isCommon |= s.charAt(0) == sReverse.charAt(i);
            if(isCommon)
                dp[0][i] = 1;
        }
        isCommon = false;
        for(int i = 0; i < n; i++) {
            isCommon |= sReverse.charAt(0) == s.charAt(i);
            if(isCommon)
                dp[i][0] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                if(s.charAt(i) == sReverse.charAt(j))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][n - 1];
    }
}

//Top down approach
class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(s, rev, 0, 0, dp);
    }

    private int helper(String s, String rev, int i, int j, int[][] dp) {
        if(i == s.length() || j == s.length())
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s.charAt(i) == rev.charAt(j))
            dp[i][j] = 1 + helper(s, rev, i + 1, j + 1, dp);
        else
            dp[i][j] = Math.max(helper(s, rev, i, j + 1, dp), helper(s, rev, i + 1, j, dp));
        return dp[i][j];
    }
}
