class Solution {
public:
    bool sumGame(string num) {
        int leftSum = 0, rightSum = 0;
        int left9 = 0, right9 = 0;
        int leftCount = 0, rightCount = 0;

        for (int i = 0; i < num.size(); i++) {
            if (i < num.size() / 2) {
                if (num[i] == '?')
                    leftCount++;
                else
                    leftSum += num[i] - '0';

                left9 += leftSum / 9;
                leftSum %= 9;
            } else {
                if (num[i] == '?')
                    rightCount++;
                else
                    rightSum += num[i] - '0';

                right9 += rightSum / 9;
                rightSum %= 9;
            }
        }

        if (leftSum == rightSum &&
            left9 - right9 == (rightCount - leftCount) / 2 &&
            (rightCount + leftCount) % 2 == 0)
            return false;
            
        return true;
    }
};