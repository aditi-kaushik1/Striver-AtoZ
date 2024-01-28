/* LeetCode
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
*/

//Clean top down approach
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums) {
            sum += x;
        }

        if(sum % 2 == 1)
            return false;

        dp = new int[sum/2 + 1][nums.length + 1];

        if(helper(nums, sum/2, 0) == 2)
            return true;
        else
            return false;
    }

    int[][] dp;

    private int helper(int[] nums, int sum, int index) {
        if(sum == 0)
            return 2;
        if(sum < 0 || (index >= nums.length))
            return 1;
        if(dp[sum][index] != 0)
            return dp[sum][index];
        if(helper(nums, sum - nums[index], index + 1) == 2 || helper(nums, sum, index + 1) == 2)
            dp[sum][index] = 2;
        else
            dp[sum][index] = 1;
        return dp[sum][index];
    }
}

//Bottom up approach
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for(int x : nums) {
//             sum += x;
//         }
//         if(sum % 2 == 1)
//             return false;

//         boolean[] dp = new boolean[sum + 1];

//         dp[0] = true;
//         dp[nums[0]] = true;

//         for(int i = 1; i < nums.length; i++) {
//             for(int j = sum/2; j >= 0; j--) {
//                 if(j - nums[i] >= 0)
//                     dp[j] = dp[j] || dp[j - nums[i]];
//                 if(dp[sum/2] == true)
//                     return true;
//             }
//         }
//         return false;
//     }
// }
