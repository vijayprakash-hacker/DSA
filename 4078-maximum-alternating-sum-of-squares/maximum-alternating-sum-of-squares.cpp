class Solution {
public:
    static bool cmp(const int& a, const int& b) {
        return (abs(a) < abs(b));
    }

    long long maxAlternatingSum(vector<int>& nums) {
        int n = nums.size();

        sort(nums.begin(), nums.end(), cmp);
        long long ans = 0;

        for(int i = n / 2; i < n; i++) ans += nums[i] * nums[i];
        for(int i = 0; i < n / 2; i++) ans -= nums[i] * nums[i];
        
        return ans;    
    }
};