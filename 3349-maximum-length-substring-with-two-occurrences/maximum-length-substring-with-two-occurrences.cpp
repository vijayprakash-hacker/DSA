class Solution {
public:
    int maximumLengthSubstring(string s) {
        vector<int> arr(26, 0);
        int j = 0, mx = 0, curr = 0;

        for (int i = 0; i < s.size(); i++) {
            int a = s[i] - 'a';
            curr++;
            arr[a]++;

            while (arr[a] > 2) {
                int b = s[j] - 'a';
                arr[b]--;
                j++;
                curr--;
            }
            
            mx = max(curr, mx);
        }

        return mx;
    }
};