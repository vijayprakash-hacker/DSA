class Solution {
public:
    int maxDepth(string s) {
        stack<int> st;
        int ans = 0;

        for(char c : s) {
            if(c == '(') {
                st.push(c);
                ans = max(ans, (int) st.size());
            } else if(c == ')') st.pop();
        }

        return ans;
    }
};