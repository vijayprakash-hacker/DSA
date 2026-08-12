class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0, curr = 0, j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }

            map.put(nums[i], map.get(nums[i]) + 1);
            curr++;

            while (map.get(nums[i]) > k) {
                map.put(nums[j], map.get(nums[j]) - 1);
                j++;
                curr--;
            }

            maxLength = Math.max(curr, maxLength);
        }

        return maxLength;

    }
}