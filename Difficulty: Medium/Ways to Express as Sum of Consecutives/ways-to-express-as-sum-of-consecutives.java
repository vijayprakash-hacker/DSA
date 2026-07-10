class Solution {
    public int getCount(int n) {
        // code here
        int count = 0;
        long twice = 2L * n;

        for (long k = 2; k * (k + 1) / 2 <= n; k++) {
            if (twice % k != 0)
                continue;
                
            long temp = twice / k - k + 1;
            
            if (temp > 0 && temp % 2 == 0)
                count++;
        }

        return count;
    }
};