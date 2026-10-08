class Solution {
public:
    string removeOuterParentheses(string s) {
        string ans;
        int l = 0;

        for(auto c : s) {
            if(c == ')') l--;
            if(l) ans.push_back(c);
            if(c == '(') l++;
        }

        return ans;
    }
};