class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        stack<int> s;
        for(int i = nums.size() - 1; i >= 0; i--) {
            s.push(nums[i]);
        }

        vector<int> ans(nums.size());

        for(int i = nums.size() - 1; i >= 0; i--) {
        while(s.size() > 0) {
            if(s.top() > nums[i]) {
                ans[i] = s.top();
                s.push(nums[i]);
                break;
            } else {
                s.pop();
            }
            }
            if(s.size() == 0) {
            ans[i] = -1;
            s.push(nums[i]);
        }
    }

    return ans;
    }
};