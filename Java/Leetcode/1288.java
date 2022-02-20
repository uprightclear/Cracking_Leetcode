class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int left = -1, right = -1, res = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int[] interval : intervals) {
            if(interval[0] > left && interval[1] > right) {
                left = interval[0];
                res++;
            }
            right = Math.max(right, interval[1]);
        }
        return res;
    }
}