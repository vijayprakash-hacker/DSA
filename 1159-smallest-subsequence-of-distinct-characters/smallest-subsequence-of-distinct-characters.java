class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] vis = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (vis[ch - 'a'])
                continue;

            while (!stack.isEmpty() && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > i) {
                vis[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            vis[ch - 'a'] = true;
        }

        String ans = "";

        while(!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }

        return ans;
    }
}