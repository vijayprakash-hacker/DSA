class Solution {
    public boolean predictTheWinner(int[] nums) {
        return canPlayer1Win(nums, 0, nums.length - 1, 0, 0, true);
    }

    private boolean canPlayer1Win(int[] nums, int l, int r, int p1, int p2, boolean isP1Turn) {
        if (l > r) {
            return p1 >= p2;
        }

        if (isP1Turn) {
            boolean pickLeft = canPlayer1Win(nums, l + 1, r, p1 + nums[l], p2, false);
            boolean pickRight = canPlayer1Win(nums, l, r - 1, p1 + nums[r], p2, false);
            return pickLeft || pickRight;
        } else {
            boolean pickLeft = canPlayer1Win(nums, l + 1, r, p1, p2 + nums[l], true);
            boolean pickRight = canPlayer1Win(nums, l, r - 1, p1, p2 + nums[r], true);
            return pickLeft && pickRight;
        }
    }
}