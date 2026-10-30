class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long min = 1, max = 0;

        for (int pile : piles) max = Math.max(max, pile);

        long ans = max;

        while (min <= max) {
            long mid = (min + max) / 2;
            long c = 0;

            for (int i = 0; i < piles.length; i++) {
                c += piles[i] / mid;
                if (piles[i] % mid != 0) c++;
            }

            if (c <= h) {
                ans = Math.min(mid, ans);
                max = mid - 1;
            } else {   
                min = mid + 1;
            }
        }

        return (int) ans;
    }
}