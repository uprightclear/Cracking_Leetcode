class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        int ans = 0;
        int end = timeSeries[0] + duration;
        for(int i = 1; i < len; i++) {
            if(timeSeries[i] >= end) ans += duration;
            else ans += timeSeries[i] - timeSeries[i - 1];
            end = timeSeries[i] + duration;
        }
        ans += duration;
        return ans;
    }
}