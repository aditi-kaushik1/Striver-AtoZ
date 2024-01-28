/* LeetCode
Given an integer array nums, return the length of the longest strictly increasing subsequence. */

//Bottom up
class Solution {
    public int lengthOfLIS(int[] nums) {
       int[] dp = new int[nums.length];
		dp[0] = 1;
		for(int i = 1; i < nums.length; i++) {
			int ans = 1;
			for(int k = i - 1; k >= 0; k--) {
				if(nums[k] < nums[i])
					ans = Math.max(ans, 1 + dp[k]);
			}
            dp[i] = ans;
		}
        int max = Integer.MIN_VALUE;
		for(int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

//Using BINARY SEARCH
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         List<Integer> ans = new ArrayList<>();
//         ans.add(nums[0]);
//         int count = 1;
//         for(int i = 1; i < nums.length; i++) {
//             if(nums[i] > ans.get(ans.size() - 1)) {
//                 ans.add(nums[i]);
//                 count++;
//             }
//             else {
//                 int left = 0;
//                 int right = ans.size() - 1;
//                 int mid = 0;
//                 int position = 0;
//                 while(left <= right) {
//                     mid = left + (right - left)/2;
//                     if(ans.get(mid) == nums[i]) {
//                         position = mid;
//                         break;
//                     }
//                     else if(ans.get(mid) > nums[i]) {
//                         position = mid;
//                         right = mid - 1;
//                     }
//                     else
//                         left = mid + 1;
//                 }
//                 ans.set(position, nums[i]);
//             }
//         }
//         return count;
//     }
// }

//Top down approach
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int[] dp = new int[nums.length];
//         LIShelper(nums, nums.length - 1, dp);
//         int max = Integer.MIN_VALUE;
//         for(int i = 0; i < dp.length; i++) {
//             max = Math.max(max, dp[i]);
//         }
//         return max;
//     }

//     private int LIShelper(int[] nums, int index, int[] dp) {
//         if(index < 0)
//             return 0;
//         LIShelper(nums, index - 1, dp);
//         int ans = 1;
//         for(int k = index - 1; k >= 0; k--) {
//             if(nums[k] < nums[index])
//                 ans = Math.max(ans, 1 + dp[k]);
//         }
//         return dp[index] = ans;
//     }
// }
