class Solution {
    public int sortPermutation(int[] nums) {
        int n = (int) Math.pow(2, 17) - 1;
        boolean sorted = true;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                n = n & i;
                sorted = false;
            }
        }

        if(sorted) return 0;
        
        return n;
    }
}