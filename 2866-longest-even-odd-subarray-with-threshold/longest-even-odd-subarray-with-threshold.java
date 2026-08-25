class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int count = 0; int max = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {

                while(i < nums.length) {
                    if(i != nums.length - 1 && nums[i] % 2 != nums[i + 1] % 2
                    && nums[i] <= threshold) count++;
                    else break;
                    i++;
                }
                
                if(nums[i] <= threshold) count++;
                max = Math.max(count, max);
                count = 0;
            }
        }

        return max;
    }
}