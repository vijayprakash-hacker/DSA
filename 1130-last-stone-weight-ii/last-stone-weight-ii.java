class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;

        for (int x : stones) {
            sum += x;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {

                // Don't take current stone
                dp[i][j] = dp[i - 1][j];

                // Take current stone
                if (j >= stones[i - 1]) {
                    dp[i][j] = dp[i][j] ||
                               dp[i - 1][j - stones[i - 1]];
                }
            }
        }

        for (int j = target; j >= 0; j--) {
            if (dp[n][j]) {
                return sum - 2 * j;
            }
        }

        return 0;
    }
}