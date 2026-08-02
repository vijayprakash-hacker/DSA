class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return isDiff(piles, 0, piles.length - 1, dp, 0) > 0;
    }

    private int isDiff(int[] piles, int l, int r, int[][] dp, int count) {
        if (l > r) {
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        count += Math.max(piles[l] - isDiff(piles, l + 1, r, dp, count),
                piles[r] - isDiff(piles, l, r - 1, dp, count));
        dp[l][r] = count;

        return count;
    }
}