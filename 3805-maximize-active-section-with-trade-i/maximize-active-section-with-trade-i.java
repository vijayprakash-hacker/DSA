class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int prefix = 0, count1 = 0, preCount0 = 0;
        int count0 = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '0') {
                count0++;
            } else {
                if (preCount0 != 0 && count0 != 0) {
                    prefix = Math.max(prefix, preCount0 + count0);
                }

                count1++;

                if (count0 != 0) {
                    preCount0 = count0;
                    count0 = 0;
                }
            }
        }

        if (s.charAt(s.length() - 1) == '0' && preCount0 != 0) {
            prefix = Math.max(prefix, preCount0 + count0);
        }

        return prefix + count1;
    }
}