class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingDouble(o -> o[1]));
        long st = Long.MIN_VALUE;
        int c = 0;

        for(int i = 0; i < points.length; i++) {
            if(points[i][0] > st) {
                c++;
                st = points[i][1];
            }
        }

        return c;
    }
}