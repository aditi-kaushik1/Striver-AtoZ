/* Coding Ninjas
  Problem statement
There is an array of heights corresponding to 'n' stones. You have to reach from stone 1 to stone ‘n’.
From stone 'i', it is possible to reach stones 'i'+1, ‘i’+2… ‘i’+'k' , and the cost incurred will be | Height[i]-Height[j] |, where 'j' is the landing stone.
Return the minimum possible total cost incurred in reaching the stone ‘n’.
  */

//Solution 1
//Bottom up approach
public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        int[] dp = new int[n];
        if(n == 1)
            return 0;
        dp[1] = Math.abs(height[1] - height[0]);

        for(int i = 2; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = i - 1; j >= Math.max(i - k, 0); j--) {
                min = Math.min(min, dp[j] + Math.abs(height[i] - height[j]));
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }
}

//Solution 2
//Top down approach
public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        int[] dp = new int[n];
        for(int i = 0; i < n; i++)
            dp[i] = -1;
        return helper(height, n - 1, k, dp);
    }

    private static int helper(int[] arr, int i, int k, int[] dp) {
        if(i == 0)
            return 0;
        if(i == 1)
            return Math.abs(arr[1] - arr[0]);
        if(dp[i] != -1)
            return dp[i];
        int min = Integer.MAX_VALUE;
        for(int j = i -1; j >= Math.max(0, i - k); j--) {
            min = Math.min(min, helper(arr, j, k, dp) + Math.abs(arr[i] - arr[j]));
        }
        return dp[i] = min;
    }
}
