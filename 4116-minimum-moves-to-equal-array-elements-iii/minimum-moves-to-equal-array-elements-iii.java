class Solution {
    public int minMoves(int[] nums) {
        int max = 0, moves = 0;
        for (int num : nums) max = Math.max(max, num);
        for(int num : nums) moves += Math.abs(num - max);
        return moves;
    }
}