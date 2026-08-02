class Solution { 
    static class Info {
        int sum;
        int index;

        Info(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public int calculate(String s) {
        return bracket(s, 0).sum;
    }

    private Info bracket(String s, int k) {
        int sum = 0, cur = 0;
        boolean value = true;

        for (int i = k; i < s.length(); i++) {
            int c = s.charAt(i);

            if (c == '(') {
                Info t = bracket(s, i + 1);
                if (value == true) {
                    sum += t.sum;
                    i = t.index;
                } else {
                    sum -= t.sum;
                    i = t.index;
                }
            } else if (c == ')') {
                if (value == true) {
                    sum += cur;
                } else {
                    sum -= cur;
                }
                return new Info(sum, i);
            } else if (c >= '0' && c <= '9') {
                cur = cur * 10 + (c - '0');
            } else if (c == '-') {
                if (value == true) {
                    sum += cur;
                } else {
                    sum -= cur;
                }
                cur = 0;
                value = false;
            } else if (c == '+') {
                if (value == true) {
                    sum += cur;
                } else {
                    sum -= cur;
                }
                cur = 0;
                value = true;
            }
        }

        if (value == true) {
            sum += cur;
        } else {
            sum -= cur;
        }
        
        return new Info(sum, -1);
    }
}