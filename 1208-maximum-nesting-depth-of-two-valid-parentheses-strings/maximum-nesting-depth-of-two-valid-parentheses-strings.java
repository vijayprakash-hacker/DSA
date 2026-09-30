class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length(), d = 0;
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                ++d;
                ans[i] = d % 2;
            } else {
                ans[i] = d % 2;
                --d;
            }
        }

        return ans;
    }
}