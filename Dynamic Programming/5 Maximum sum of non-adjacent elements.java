/* Coding Ninjas
  Problem statement
You are given an array/list of ‘N’ integers. You are supposed to return the maximum sum of the subsequence with the constraint that no two elements are adjacent in the given array/list. */

import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
    //Bottom up approach
		int n = nums.size();
		int[] dp = new int[n];
		dp[0] = nums.get(0);
		if(n == 1)
			return nums.get(0);
		dp[1] = Math.max(nums.get(0), nums.get(1));
		for(int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums.get(i));
		}
		return dp[n - 1];

  // Top down approach
	// 	int n = nums.size();
	// 	int[] dp = new int[n];
	// 	for(int i = 0; i < n; i++)
	// 		dp[i] = -1;
	// 	return helper(nums, 0, dp);
	// }

	// private static int helper(ArrayList<Integer> nums, int i, int[] dp) {
	// 	if(i >= nums.size())
	// 		return 0;
	// 	if(dp[i] != -1)
	// 		return dp[i];
	// 	return dp[i] = Math.max(helper(nums, i + 2, dp) + nums.get(i), helper(nums, i + 1, dp));
	}
}
