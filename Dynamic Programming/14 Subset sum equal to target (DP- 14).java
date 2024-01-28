/* Coding Ninjas
Problem statement
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.
Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.
*/

//Bottom up approach
// import java.util.* ;
// import java.io.*; 
// public class Solution {
//     public static boolean subsetSumToK(int n, int k, int arr[]){
//         boolean[][] dp = new boolean[n][k + 1];
//         if(arr[0] <= k)
//             dp[0][arr[0]] = true;
//         for(int i = 0; i < n; i++)
//             dp[i][0] = true;
//         for(int i = 1; i < n; i++) {
//             for(int j = 1; j <= k; j++) {
//                 if(arr[i] <= j)
//                     dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i]];
//                 else
//                     dp[i][j] = dp[i - 1][j];
//             }
//         }
//         return dp[n - 1][k];
//     }
// }

//Top down approach
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        if(helper(0, k, arr, dp) == 1)
            return true;
        else
            return false;
    }

    private static int helper(int i, int k, int[] arr, int[][] dp) {
        //First check if k is 0 or not. It can become 0 after the last element, 
        //which will get neglected if you check for an invalid index before k.
        if(k == 0)
            return 1;
        if(i == arr.length)
            return 0;
        if(dp[i][k] != -1)
            return dp[i][k];
        if(arr[i] <= k)
            dp[i][k] = helper(i + 1, k, arr, dp) | helper(i + 1, k - arr[i], arr, dp);
        else
            dp[i][k] = helper(i + 1, k, arr, dp);
        return dp[i][k];
    }
}
