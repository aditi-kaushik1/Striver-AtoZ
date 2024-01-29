/* Coding Ninjas
Problem statement
Given a chain of matrices A1, A2, A3,.....An, you have to figure out the most efficient way to multiply these matrices. In other words, determine where to place parentheses to minimize the number of multiplications.
You will be given an array p[] of size n + 1. Dimension of matrix Ai is p[i - 1]*p[i]. You need to find minimum number of multiplications needed to multiply the chain.
*/

//Top down approach
//Time complexity: O(n^3)
//Space complexity: O(n^2) + auxillary stack space O(n)
public class Solution {
	public static int mcm(int[] arr){
		int n = arr.length;
		int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(arr, 1, n - 1, dp);
    }
    
    private static int helper(int[] arr, int i, int j, int[][] dp) {
        if(i == j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            min = Math.min(min, helper(arr, i, k, dp) + helper(arr, k + 1, j, dp) + arr[i - 1]*arr[k]*arr[j]);
        }
        return dp[i][j] = min;
	}
}

//Botoom up approach
//Time complexity: O(n^3)
//Space complexity: O(n^2)

public class Solution {
	public static int mcm(int[] p){
        int n = p.length;
		int[][] dp = new int[n][n];

        for(int len = 2; len < n; len++) {
            for(int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                int min = Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    min = Math.min(min, p[i - 1]*p[k]*p[j] + dp[i][k] + dp[k + 1][j]);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n - 1];
	}
}
