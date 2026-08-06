class Solution {
    public int smallestNumber(int n, int t) {
        int prd = 1, temp = n;
        
        while (temp > 0) {
            prd *= temp % 10;
            temp /= 10;
        }

        while (prd % t != 0) {
            n++;
            prd = 1;
            int p = n;

            while (p > 0) {
                prd *= p % 10;
                p /= 10;
            }
        }

        return n;
    }
}