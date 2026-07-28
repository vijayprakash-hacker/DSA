class Solution {
    public String smallestPalindrome(String s) {
        int[] pos = new int[26];

        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a']++;
        }

        char[] ans = new char[s.length()];
        int start = 0;

        for (int i = 0; i < pos.length; i++) {
            while (pos[i] > 1) {
                char ch = (char) ('a' + i);
                ans[start] = ch;
                ans[s.length() - start - 1] = ch;
                pos[i] -= 2;
                start++;
            }
        }

        for (int i = 0; i < pos.length; i++) {
            if (pos[i] == 1) {
                ans[start] = (char) ('a' + i);
                break;
            }
        }

        return String.valueOf(ans);
    }
}