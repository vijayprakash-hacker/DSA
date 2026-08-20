class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();

        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            while (!s.isEmpty() && heights[i] > s.peek()) {
                count++;
                s.pop();
            }
            
            if (!s.isEmpty())
                count++;
            s.push(heights[i]);
            ans[i] = count;
        }

        return ans;
    }
}