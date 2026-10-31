class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int prev_end = intervals[0][1];
        for(int i = 1; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start < prev_end) {
                ans++;
                prev_end = Math.min(prev_end, end);
            } else {
                prev_end = end;
            }
        }
        return ans;
    }
}
