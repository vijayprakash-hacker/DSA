class Solution {
    public int largestInteger(int[] nums, int k) {
        int max = -1, n = nums.length;

        if (k == n) {
            for (int num : nums) {
                max = Math.max(num, max);
            }
            return max;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, 0);
            map.put(num, map.get(num) + 1);
        }

        if (k == 1) {
            for (int num : nums) {
                if (map.get(num) == 1)
                    max = Math.max(num, max);
            }
            return max;
        }

        if (map.get(nums[0]) == 1) max = Math.max(nums[0], max);
        if (map.get(nums[n - 1]) == 1) max = Math.max(nums[n - 1], max);

        return max;
    }
}