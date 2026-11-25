class Solution {
    public int minDistance(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return lcs(a, b, n, m, dp);
    }

    public int lcs(String a, String b, int n, int m, int[][] dp) {
        if (n == 0 || m == 0)
            return (n == 0 ? m : n);
        if (dp[n][m] != -1)
            return dp[n][m];

        if (a.charAt(n - 1) == b.charAt(m - 1)) {
            return dp[n][m] = lcs(a, b, n - 1, m - 1, dp);
        } else {
            int insert = 1 + lcs(a, b, n, m - 1, dp);
            int remove = 1 + lcs(a, b, n - 1, m, dp);
            int replace = 1 + lcs(a, b, n - 1, m - 1, dp);
            return dp[n][m] = Math.min(replace, Math.min(insert, remove));
        }
    }
}