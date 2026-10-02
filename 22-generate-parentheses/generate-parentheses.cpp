class Solution {
public:
    vector<string> generate(vector<string>& v, string s, int left, int right) {
        if(left == 0 && right == 0) {
            v.push_back(s);
            return v;
        }

        if(left == right) {
            generate(v, s + '(', left - 1, right);
        } else if(left == 0){
            generate(v, s + ')', left, right - 1);
        } else {
            generate(v, s + '(', left - 1, right);
            generate(v, s + ')', left, right - 1);
        }

        return v;
    }
    vector<string> generateParenthesis(int n) {
        vector<string> v;
        string s = "";
        return generate(v, s, n, n);
    }
};