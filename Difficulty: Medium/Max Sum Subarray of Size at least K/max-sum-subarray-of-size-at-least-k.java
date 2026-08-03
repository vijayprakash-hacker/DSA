class Solution {
    public int maxSumWithK(int[] arr, int k) {
        // code here
        int n = arr.length;
        
        int[] dp = new int[n];
        dp[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
        }
        
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;
        
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];

            int currentMax = windowSum;

            if (dp[i - k] > 0) {
                currentMax += dp[i - k];
            }

            maxSum = Math.max(maxSum, currentMax);
        }

        return maxSum;
    }
}