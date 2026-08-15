class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = nums[0];

        for (int i = 1; i < n; i++) {
            xor ^= nums[i];
        }

        if (xor != 0)
            return n;

        for (int i = 0; i < n; i++) {
            int t = xor ^ nums[i];
            if (t != 0)
                return n - 1;
        }

        return 0;
    }
}