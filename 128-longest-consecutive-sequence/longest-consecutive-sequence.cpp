class Solution {
public:
    int longestConsecutive(vector<int>& arr) {
        int n = arr.size(), longest = 0;
        if (n == 0) return 0;
        unordered_set<int> s;

        for (int i = 0; i < n; i++) {
            s.insert(arr[i]);
        }

        for (auto it : s) {
            if (s.find(it - 1) == s.end()) {
                int cnt = 1;
                int ele = it;
                while (s.find(ele + 1) != s.end()) {
                    cnt++;
                    ele = ele + 1;
                }
                longest = max(longest, cnt);
            }
        }
        
        return longest;
    }
};