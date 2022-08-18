class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int len = startTime.length;
        int ans = 0;
        for(int i = 0; i < len; i++) {
            if(startTime[i] <= queryTime && queryTime <= endTime[i]) ans++;
        }
        return ans;
    }
}