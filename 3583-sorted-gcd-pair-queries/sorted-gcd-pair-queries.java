class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;

        for(int num : nums) {
            max = Math.max(num, max);
        }

        int[] freq = new int[max + 1];

        for(int num : nums) {
            freq[num]++;
        }

        long[] gcdCount = new long[max + 1];

        for(int i = max; i >= 1; i--) {
            int cnt = 0;

            for(int j = i; j <= max; j += i) {
                cnt += freq[j];
            }

            gcdCount[i] = 1L * cnt * (cnt - 1) / 2;

            for(int j = i * 2; j <= max; j += i) {
                gcdCount[i] -= gcdCount[j];
            }
        }

        long[] prefix = new long[max + 1];

        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + gcdCount[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long q = queries[i];
            int l = 1;
            int r = max;

            while (l < r) {
                int mid = (l + r) / 2;

                if (prefix[mid] > q) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            ans[i] = l;
        }

        return ans;
    }
}