class Solution {
    public int minPathSum(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0 && j == 0) dp[i][j] = arr[i][j];
                else if(i == 0) dp[i][j] = arr[i][j] + dp[i][j - 1];
                else if(j == 0) dp[i][j] = arr[i][j] + dp[i - 1][j];
                else dp[i][j] = arr[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[n - 1][m - 1];
    }
}