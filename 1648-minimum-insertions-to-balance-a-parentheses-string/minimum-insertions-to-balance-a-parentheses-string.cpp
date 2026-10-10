class Solution {
public:
    int minInsertions(string s) {
        vector<char> st;
        int n = s.size(), i = 0, ans = 0;

        while (i < n) {
            if (s[i] == '(') {
                st.push_back('(');
                i++;
            } else {
                if (i + 1 < n && s[i + 1] == ')') {
                    i += 2;
                } else {
                    ans++;
                    i++;
                }

                if (!st.empty()) {
                    st.pop_back();
                } else {
                    ans++;
                }
            }
        }

        ans += 2 * st.size();

        return ans;
    }
};