class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length, ans = 0;

        for (int i = 0; i < n; i++) {
            int[] prd = new int[n - i + 1];
            int[] gcd = new int[n - i + 1];
            int[] lcm = new int[n - i + 1];

            for (int j = i; j < n; j++) {
                if(j == i) {
                    prd[j - i] = nums[j];
                    gcd[j - i] = nums[j];
                    lcm[j - i] = nums[j];
                } else {
                    prd[j - i] = nums[j] * prd[j - i - 1];
                    gcd[j - i] = gcd(gcd[j - i - 1], nums[j]);
                    lcm[j - i] = lcm[j - i - 1] * nums[j] / gcd(lcm[j - i - 1], nums[j]);
                }
                if(prd[j - i] == gcd[j - i] * lcm[j - i]) ans = Math.max(ans, j - i + 1);
            }
        }

        return ans;
    }

    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}