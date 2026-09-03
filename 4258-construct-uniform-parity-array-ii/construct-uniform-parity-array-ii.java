class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE, ecount = 0, ocount = 0;

        for(int i = 0; i < nums1.length; i++) {
            if(nums1[i] % 2 != 0) {
                ocount++;
                min = Math.min(min,nums1[i]);
            }else {
                ecount++;
            }
        }

        if(ecount == nums1.length || ocount == nums1.length) return true;

        for(int i = 0; i < nums1.length; i++) {
            if(nums1[i] % 2 == 0) {
                if(nums1[i] < min) return false;
            } 
        }
        
        return true;
    }
}