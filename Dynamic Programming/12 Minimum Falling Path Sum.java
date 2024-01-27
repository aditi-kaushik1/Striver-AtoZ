/*LeetCode
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. 
Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1). */

//Method 1
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         dp = new int[n][n];
//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j < n; j++) {
//                 dp[i][j] = -100000000;
//             }
//         }
//         int ans = Integer.MAX_VALUE;
//         for(int j = 0; j < n; j++) {
//             ans = Math.min(ans, helper(matrix, n - 1, j, n));
//         }
//         return ans;
//     }

//     int[][] dp;

//     private int helper(int[][] matrix, int i, int j, int n) {

//         System.out.println(i + " " + j);
//         if(i == 0)
//             return matrix[i][j];
//         if(dp[i][j] != -100000000)
//             return dp[i][j];
//         int ans = Integer.MAX_VALUE;
//         for(int k = j - 1; k <= j + 1; k++) {
//             if(k >= 0 && k <= n - 1) {
//                 ans = Math.min(ans,helper(matrix, i - 1, k, n));
//             }
//         }
//         dp[i][j] = ans + matrix[i][j];
//         return dp[i][j];
//     }
// }

//Method 2
//Intuitive
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n == 1)
            return matrix[0][0];

        int[][] ans = new int[n][n];
        for(int i = 0; i < n; i++) {
            ans[0][i] = matrix[0][i];
        }

        int minimumSum = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int min = ans[i - 1][j];
                if(isValidIndex(i - 1, j - 1, n))
                    min = Math.min(min, ans[i - 1][j - 1]);
                if(isValidIndex(i - 1, j + 1, n))
                    min = Math.min(min, ans[i - 1][j + 1]);
                ans[i][j] = min + matrix[i][j];
                if(i == n - 1)
                    minimumSum = Math.min(minimumSum, ans[i][j]);
            }
        }
        return minimumSum;
    }

    private boolean isValidIndex(int i, int j, int n) {
        return (i >= 0 && i < n && j >= 0 && j < n);
    }
}

//Method 3
//Space Optimisation
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         if(n == 1)
//             return matrix[0][0];

//         int[][] ans = new int[n][n];
//         for(int i = 0; i < n; i++) {
//             ans[0][i] = matrix[0][i];
//         }

//         int minimumSum = Integer.MAX_VALUE;
//         for(int i = 1; i < n; i++) {
//             for(int j = 0; j < n; j++) {
//                 int min = ans[i - 1][j];
//                 if(isValidIndex(i - 1, j - 1, n))
//                     min = Math.min(min, ans[i - 1][j - 1]);
//                 if(isValidIndex(i - 1, j + 1, n))
//                     min = Math.min(min, ans[i - 1][j + 1]);
//                 ans[i][j] = min + matrix[i][j];
//                 if(i == n - 1)
//                     minimumSum = Math.min(minimumSum, ans[i][j]);
//             }
//         }
//         return minimumSum;
//     }

//     private boolean isValidIndex(int i, int j, int n) {
//         return (i >= 0 && i < n && j >= 0 && j < n);
//     }
// }
