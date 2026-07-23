class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n <= 2)
            return n;

        int max = 1;

        while (max <= n) {
            max *= 2;
        }

        return max;
    }
}