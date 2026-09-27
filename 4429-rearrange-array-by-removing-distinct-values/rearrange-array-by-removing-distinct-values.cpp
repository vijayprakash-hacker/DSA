class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        vector<int> freq(101, 0);
        vector<int> ans;

        for(int i = 0; i < nums.size(); i++) {
            freq[nums[i]]++;
        }

        int remaining = nums.size();

        while(remaining > 0) {
            for(int i = 1; i <= 100; i++) {
                if(freq[i] > 0) {
                    ans.push_back(i);
                    freq[i]--;
                    remaining--;
                }
            }
        }

        return ans;
    }
};