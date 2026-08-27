class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        StringBuilder ss = new StringBuilder("");
        for(int i = 0; i < target.length(); i++) {
            if(arr[target.charAt(i) - 'a'] != 0) {
                ss.append(target.charAt(i));
                arr[target.charAt(i) - 'a']--;
            } else {
                boolean found = false;

                for(int j = target.charAt(i) - 'a' + 1; j < arr.length; j++) {
                    if(arr[j] != 0) {
                        ss.append((char) ('a' + j));
                        arr[j]--;
                        found = true;
                        break;
                    }
                }
                
                if(found) {
                    for(int k = 0; k < arr.length; k++) {
                        while(arr[k] != 0) {
                            ss.append((char) ('a' + k));
                            arr[k]--; 
                        }
                    }

                    return ss.toString();
                }

                if(i == 0) return "";
                break;
            }
        }

        for(int i = ss.length() - 1; i >= 0; i--) {
            arr[ss.charAt(i) - 'a']++;
            int cur = target.charAt(i) - 'a';

            for(int j = cur + 1; j < 26; j++) {
                if(arr[j] != 0) {
                    StringBuilder ans = new StringBuilder(target.substring(0, i));
                    ans.append((char) ('a' + j));
                    arr[j]--;

                    for(int k = 0; k < 26; k++) {
                        while(arr[k] != 0) {
                            ans.append((char) ('a' + k));
                            arr[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}