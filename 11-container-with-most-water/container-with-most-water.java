class Solution {
    public int maxArea(int[] height) {
        int str=0 , lst = height.length-1, area = 0;

        while(str<lst){
            int width = lst - str;
            int length = Math.min(height[str], height[lst]);
            area = Math.max(area, width*length);
            if(height[str] < height[lst]){
                str++;
            }else {
                lst--;
            }
        }
        
        return area;
    }
}