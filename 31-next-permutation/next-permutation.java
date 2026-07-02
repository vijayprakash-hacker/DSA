class Solution {
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int pivot = -1, n = nums.length;
        
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if(pivot == -1) {
            reverse(nums, 0, n - 1);
        } else {

            for(int i = n - 1; i > pivot; i--) {
                if(nums[i] > nums[pivot]) {
                    int temp = nums[i];
                    nums[i] = nums[pivot];
                    nums[pivot] = temp;
                    break;
                }
            }

            reverse(nums, pivot + 1, n - 1);
        }
    }
}