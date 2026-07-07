class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0, count = 0, placeValue = 1;

        while(n > 0) {
            int rem = n % 10;

            if(rem != 0) {
                sum += rem;
                count += rem * placeValue;
                placeValue *= 10;
            }

            n /= 10;
        }

        return sum * count;
    }
}