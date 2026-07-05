class Solution {
    public int maxCharGap(String s) {
        // code here
         HashMap<Character, Integer> map = new HashMap<>();
        int ans = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, i);
            } else {
                int gap = i - map.get(ch) - 1;
                ans = Math.max(ans, gap);
            }
        }

        return ans;
    }
};