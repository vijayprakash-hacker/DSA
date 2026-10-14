class Solution {
public:
    string maxSumOfSquares(int num, int sum) {
        string ans = "";

        for(int i = 1; i <= num; i++) {
            int c = min(sum, 9);
            sum -= c;
            ans.push_back(c + '0');
        }

        if(sum != 0) return "";

        return ans;
    }
};