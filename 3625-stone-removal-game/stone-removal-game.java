class Solution {
    public boolean canAliceWin(int n) {
        boolean v = false;
        int t = 10;
        while (n >= t) {
            n -= t;
            t--;
            v = !v;
        }
        return v;
    }
}