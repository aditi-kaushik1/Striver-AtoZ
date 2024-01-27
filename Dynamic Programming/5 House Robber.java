/* LeetCode- You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected 
  and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police. */

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        int secondLast = nums[0];
        int last = Math.max(nums[0], nums[1]);
        int curr = last;
        for(int i = 2; i < n; i++) {
            curr = Math.max(secondLast + nums[i], last);
            secondLast = last;
            last = curr;
        }
        return curr;
    }
}
