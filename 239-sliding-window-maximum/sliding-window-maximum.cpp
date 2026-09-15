class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& arr, int k) {
        vector<int> ans(arr.size());
        stack<int> s;

        for(int i = arr.size() - 1; i >= 0; i--) {
            while(s.size() > 0 && arr[s.top()] <= arr[i]) {
                s.pop();
            }
            if(s.size() > 0) {
                ans[i] = s.top();
            } else {
                ans[i] = arr.size(); 
            }
            s.push(i);
        }

        vector<int> a;
        for(int i = 0; i <= arr.size() - k; i++) {
            int j = i;
            while(ans[j] < i + k) {
                j = ans[j];
            } 
            a.push_back(arr[j]);
        }
        return a;
    }
};