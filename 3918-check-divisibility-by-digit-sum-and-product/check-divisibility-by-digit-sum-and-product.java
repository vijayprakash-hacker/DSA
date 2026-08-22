class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, prd = 1;

        int t = n;
        while (t > 0) {
            sum += t % 10;
            prd *= t % 10;
            t /= 10;
        }

        return n % (sum + prd) == 0;
    }
}