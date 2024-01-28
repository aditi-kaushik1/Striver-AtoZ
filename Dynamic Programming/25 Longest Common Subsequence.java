//Bottom up approach
// class Solution {
//     public int longestCommonSubsequence(String s1, String s2) {
//         int x = s1.length();
//         int y = s2.length();
//         int[][] dp = new int[x + 1][y + 1];
//         boolean isCharSame = false;
        
//         for(int i = 1; i <= x; i++)
//             for(int j = 1; j <= y; j++)
//                 if(s1.charAt(i - 1) == s2.charAt(j - 1))
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 else
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        
//         return dp[x][y];
//     }
// }

//Top down approach
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++) {
            for(int j = 0; j < text2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return helper(text1, text2, 0, 0, dp);
    }

    private int helper(String s1, String s2, int i, int j, int[][] dp) {
        if(i == s1.length() || j == s2.length())
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + helper(s1, s2, i + 1, j + 1, dp);
        return dp[i][j] = Math.max(helper(s1, s2, i + 1, j, dp), helper(s1, s2, i, j + 1, dp));
    }
}
