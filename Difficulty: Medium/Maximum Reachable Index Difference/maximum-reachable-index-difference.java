class Solution {
    public int maxIndexDifference(String s) {
        // code here
        char c = 'a';
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == 'a') break;
            if(i == s.length() - 1) return -1;
            i++;
        }
        
        int start = i, end = -1;
        while(i < s.length()) {
            if(s.charAt(i) == c + 1) {
                c = s.charAt(i);
                end = i;
            } else if(s.charAt(i) != 'a' && s.charAt(i) <= c){
                end = i;
            }
            i++;
        }
        if(end == -1) return 0;
        return end - start;
    }
}