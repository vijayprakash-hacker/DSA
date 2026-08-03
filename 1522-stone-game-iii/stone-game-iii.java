class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        int x = isDiff(stoneValue, 0, dp);

        if (x == 0) {
            return "Tie";
        } else if (x > 0) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

    private int isDiff(int[] stoneValue, int s, int[] dp) {
        if (s > dp.length - 1) {
            return 0;
        }

        if (dp[s] != Integer.MIN_VALUE) {
            return dp[s];
        }

        int n = stoneValue[s] - isDiff(stoneValue, s + 1, dp);

        if (s + 1 < dp.length) {
            n = Math.max(n, stoneValue[s] + stoneValue[s + 1] - isDiff(stoneValue, s + 2, dp));
        }

        if (s + 2 < dp.length) {
            n = Math.max(n, stoneValue[s] + stoneValue[s + 1] + stoneValue[s + 2] - isDiff(stoneValue, s + 3, dp));
        }

        dp[s] = n;

        return dp[s];
    }
}