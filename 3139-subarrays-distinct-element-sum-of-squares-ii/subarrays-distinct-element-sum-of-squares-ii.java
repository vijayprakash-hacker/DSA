class Solution {
    static final long MOD = 1_000_000_007;

    long[] sum;
    long[] squareSum;
    long[] lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new long[4 * n];
        squareSum = new long[4 * n];
        lazy = new long[4 * n];

        int[] lastSeen = new int[100001];
        java.util.Arrays.fill(lastSeen, -1);

        long ans = 0;

        for(int i = 0; i < n; i++) {
            int prev = lastSeen[nums[i]];
            update(0, 0, n - 1, prev + 1, i);
            lastSeen[nums[i]] = i;
            ans = (ans + squareSum[0]) % MOD;
        }

        return (int) ans;
    }

    void apply(int node, int start, int end, long val) {
        long len = end - start + 1;

        squareSum[node] = (squareSum[node] + 2 * val * sum[node] + val * val * len) % MOD;

        sum[node] = (sum[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    void push(int node, int start, int end) {
        if(lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        apply(2 * node + 1, start, mid, lazy[node]);
        apply(2 * node + 2, mid + 1, end, lazy[node]);

        lazy[node] = 0;
    }

    void update(int node, int start, int end, int left, int right) {
        if(start > right || end < left) {
            return;
        }

        if(left <= start && end <= right) {
            apply(node, start, end, 1);
            return;
        }

        push(node, start, end);

        int mid = start + (end - start) / 2;

        update(2 * node + 1, start, mid, left, right);
        update(2 * node + 2, mid + 1, end, left, right);

        sum[node] = (sum[2 * node + 1] + sum[2 * node + 2]) % MOD;
        squareSum[node] = (squareSum[2 * node + 1] + squareSum[2 * node + 2]) % MOD;
    }
}