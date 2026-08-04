class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        return robber(nums, dp, 0);
    }

    int robber(int[] nums, int[] dp, int s) {
        if (s >= nums.length) {
            return 0;
        }

        if (dp[s] != -1) {
            return dp[s];
        }

        dp[s] = Math.max(robber(nums, dp, s + 1), nums[s] + robber(nums, dp, s + 2));

        return dp[s];
    }
}