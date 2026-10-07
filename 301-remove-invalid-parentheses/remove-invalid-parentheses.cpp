class Solution {
public:
    set<string> lovedOne;

    void traverse(string &s, int start, int openRemove, int closeRemove, 
                  int open, string &newS) {
        
        if(start == s.size()) {
            if(openRemove == 0 && closeRemove == 0 && open == 0) {
                lovedOne.insert(newS);
            }
            return;
        }

        if(s[start] == '(') {
            if(openRemove > 0) {
                traverse(s, start + 1, openRemove - 1, closeRemove, 
                         open, newS);
            }

            newS.push_back(s[start]);

            traverse(s, start + 1, openRemove, closeRemove, 
                     open + 1, newS);

            newS.pop_back();
        }
        else if(s[start] == ')') {
            if(closeRemove > 0) {
                traverse(s, start + 1, openRemove, closeRemove - 1, 
                         open, newS);
            }

            if(open > 0) {
                newS.push_back(s[start]);

                traverse(s, start + 1, openRemove, closeRemove, 
                         open - 1, newS);

                newS.pop_back();
            }
        }
        else {
            newS.push_back(s[start]);

            traverse(s, start + 1, openRemove, closeRemove, 
                     open, newS);

            newS.pop_back();
        }
    }

    vector<string> removeInvalidParentheses(string s) {
        int openRemove = 0;
        int closeRemove = 0;

        for(char c : s) {
            if(c == '(') {
                openRemove++;
            }
            else if(c == ')') {
                if(openRemove > 0)
                    openRemove--;
                else
                    closeRemove++;
            }
        }

        string newS = "";

        traverse(s, 0, openRemove, closeRemove, 0, newS);

        vector<string> ans;

        for(auto i : lovedOne) {
            ans.push_back(i);
        }

        return ans;
    }
};