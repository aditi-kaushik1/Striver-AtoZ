/* LeetCode 
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police. */

//Bottom up approach
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        int[] dp = new int[n];
        
        //Case where first house is not robbed and last house can be robbed.
        dp[0] = 0;
        dp[1] = nums[1];
        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int possibleAns = dp[n - 1];

        //Case where first house is robbed and last house can't be robbed
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[ i - 1], dp[i - 2] + nums[i]);
        }
        return Math.max(possibleAns, dp[n - 2]);
    }
}

//Top down approach
// class Solution {
//     public int rob(int[] nums) {
//         dp = new int[nums.length][2];
//         for(int i = 0; i < nums.length; i++) {
//             dp[i][0] = -1;
//             dp[i][1] = -1;
//         }
//         return helper(nums, 0, 0);
//     }

//     int[][] dp;

//     private int helper(int[] nums, int index, int didWeTake0) {
//         if(index >= nums.length)
//             return 0;
//         if(index == nums.length - 1) {
//              if(didWeTake0 == 0) {
//                  return nums[nums.length - 1];
//              }
//              else
//                 return 0;
//         }
//         if(index == 0) {
//             return Math.max(helper(nums, index + 1, 0), nums[0] + helper(nums, index + 2, 1));
//         }
//         if(dp[index][didWeTake0] != -1)
//             return dp[index][didWeTake0];
//         dp[index][didWeTake0] = Math.max(helper(nums, index + 1, didWeTake0), nums[index] + helper(nums, index + 2, didWeTake0));
//         return dp[index][didWeTake0];
//     }
// }

//Another method
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n == 1)
//             return nums[0];
//         if(n == 2)
//             return Math.max(nums[0] , nums[1]);
//         int[] dp = new int[n];
//         for(int i = 0; i < n; i++) {
//             dp[i] = -1;
//         }
//         int ans = nums[0] + helper(Arrays.copyOfRange(nums, 2, n - 1), 0, dp);
//         for(int i = 0; i < n; i++) {
//             dp[i] = -1;
//         }
//         ans = Math.max(ans, helper(Arrays.copyOfRange(nums, 1, n), 0, dp));
//         return ans;
//     }

//     private int helper(int[] nums, int index, int[] dp) {
//         if(index >= nums.length)
//             return 0;
//         if(dp[index] != -1)
//             return dp[index];
//         dp[index] = Math.max(helper(nums, index + 1, dp), nums[index] + helper(nums, index + 2, dp));
//         return dp[index];
//     }
// }
