class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int st = s.length - 1, c = 0;

        for(int i = g.length - 1; i >= 0; i--) {
            if(st < 0) break;
            if(g[i] <= s[st]) {
                c++;
                st--;
            }
        }

        return c;
    }
}