class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return traverse(dp, m, n, 0, 0);
    }

    private int traverse(int[][] dp, int m, int n, int i, int j) {
        if (i == m || j == n) {
            return 0;
        } else if (i == m - 1 && j == n - 1) {
            return 1;
        } else if (dp[i][j] != 0) {
            return dp[i][j];
        }

        dp[i][j] = traverse(dp, m, n, i + 1, j) + traverse(dp, m, n, i, j + 1);
        return dp[i][j];
    }
}