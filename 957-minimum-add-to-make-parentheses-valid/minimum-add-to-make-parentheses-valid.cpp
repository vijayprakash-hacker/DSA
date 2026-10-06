class Solution {
public:
    int minAddToMakeValid(string s) {
        int l = 0, ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '(') l++;
            else l--;
            
            if(l < 0) {
                ans++;
                l = 0;
            }
        }

        return ans + l;
    }
};