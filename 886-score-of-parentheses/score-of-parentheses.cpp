class Solution {
public:
    int scoreOfParentheses(string s) {
        stack<int> st;
        st.push(0);

        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                st.push(0);
            } else {
                int n = st.top();
                st.pop();
                if (n == 0) {
                    st.top()++;
                } else {
                    st.top() += n * 2;
                }
            }
        }

        return st.top();
    }
};