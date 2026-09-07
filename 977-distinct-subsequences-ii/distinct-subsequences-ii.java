class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        long[] dp = new long[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            long sumDp = 0;
            for (long count : dp) {
                sumDp = (sumDp + count) % mod;
            }

            dp[idx] = (sumDp + 1) % mod;
        }

        long totalSum = 0;
        for (long count : dp) {
            totalSum = (totalSum + count) % mod;
        }

        return (int) totalSum;
    }
}