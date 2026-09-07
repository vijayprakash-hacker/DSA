class Solution {
    public String defangIPaddr(String address) {
        String s = "";

        for(int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.') s = s + "[.]";
            else s = s + address.substring(i, i + 1);
        }

        return s;
    }
}