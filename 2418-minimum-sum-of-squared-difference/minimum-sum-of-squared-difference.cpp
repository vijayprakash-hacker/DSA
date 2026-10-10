class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        int n = nums1.size();
        vector<int> arr(n);
        int maxi = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = abs(nums1[i] - nums2[i]);
            maxi = max(maxi, arr[i]);
        }

        long long t = (long long)k1 + k2;
       
       vector<int> bucket(maxi + 1);
       for(int x : arr) bucket[x]++;

       for (int i = maxi; i > 0 && t > 0; i--) {
            int take = min((long long)bucket[i], t);
            bucket[i] -= take;
            bucket[i - 1] += take;
            t -= take;
        }

        long long ans = 0;
        for (int i = 1; i <= maxi; i++) {
            ans += 1LL * bucket[i] * i * i;
        }

        return ans;
    }
};