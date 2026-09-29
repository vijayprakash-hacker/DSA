class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[1]));
        int st = Integer.MIN_VALUE, c = 0;

        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] >= st) {
                c++;
                st = intervals[i][1];
            }
        }

        return intervals.length - c;
    }
}