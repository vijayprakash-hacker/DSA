class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> seq = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int m = seq.size();
            if(m == 0 || nums[i] > seq.get(m - 1)) {
                seq.add(nums[i]);
            } else {
                int low = 0, high = m - 1;
                while(low <= high) {
                    int mid = low + (high - low) / 2;
                    if(seq.get(mid) >= nums[i]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }

                seq.set(low, nums[i]);
            }
        }

        return seq.size();
    }
}