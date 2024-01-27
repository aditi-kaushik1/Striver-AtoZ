/* Coding Ninjas Problem statement
There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 
'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). 
If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

For Example
If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20. */

//Solution 1
//Bottom Up Approach
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        dp[1] = Math.abs(heights[1] - heights[0]);
        for(int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(heights[i] - heights[i - 1]), 
            dp[i - 2] + Math.abs(heights[i] - heights[i - 2]));
        }
        return dp[n - 1];
    }
}

//Solution 2
//Top Down Approach
// import java.util.* ;
// import java.io.*; 
// public class Solution {
//     public static int frogJump(int n, int heights[]) {
//         int[] dp = new int[n];
//         for(int i = 0; i < n; i++)
//             dp[i] = -1;
//         return helper(n - 1, heights, dp);
//     }

//     private static int helper(int n, int[] arr, int[] dp) {
//         if(n == 0)
//             return 0;
//         if(n == 1)
//             return Math.abs(arr[1] - arr[0]);
//         if(dp[n] != -1)
//             return dp[n];
//         return dp[n] = Math.min(
//             helper(n - 1, arr, dp) + Math.abs(arr[n] - arr[n - 1]),
//             helper(n - 2, arr, dp) + Math.abs(arr[n] - arr[n - 2]));
//     }
// }
