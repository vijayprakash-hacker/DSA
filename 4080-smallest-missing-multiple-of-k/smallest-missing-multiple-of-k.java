class Solution {
    public int missingMultiple(int[] nums, int k) {
        int max = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num % k == 0) {
                set.add(num / k);
                max = Math.max(max, num);
            }
        }

        for (int i = 1; i <= max + 1; i++) {
            if (!set.contains(i)) return i * k;
        }

        return k;
    }
}