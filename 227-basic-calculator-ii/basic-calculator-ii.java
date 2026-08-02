class Solution {
    public int calculate(String s) {
        int sum = 0, curr = 0, prev = -1;
        boolean as = true, md = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                curr = curr * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                if (prev != -1) {
                    int temp;
                    if (md == true) {
                        temp = prev * curr;
                    } else {
                        temp = prev / curr;
                    }
                    if (as == true) {
                        sum += temp;
                    } else {
                        sum -= temp;
                    }
                    curr = 0;
                    prev = -1;
                } else {
                    if (as == true) {
                        sum += curr;
                    } else {
                        sum -= curr;
                    }
                    curr = 0;
                }

                if (c == '+') {
                    as = true;
                } else {
                    as = false;
                }
            } else if (c == '*' || c == '/') {
                if (prev != -1) {
                    if (md == true) {
                        prev *= curr;
                        curr = 0;
                    } else {
                        prev /= curr;
                        curr = 0;
                    }
                } else {
                    prev = curr;
                    curr = 0;
                }

                if (c == '*') {
                    md = true;
                } else {
                    md = false;
                }
            }
        }

        if (prev != -1) {
            int temp;
            if (md == true) {
                temp = prev * curr;
            } else {
                temp = prev / curr;
            }
            if (as == true) {
                sum += temp;
            } else {
                sum -= temp;
            }
        } else {
            if (as == true) {
                sum += curr;
            } else {
                sum -= curr;
            }
        }

        return sum;
    }
}