class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        //the longest time is the max time * the max totalTrips = 10^7 * 10^7 = 10^14
        long left = 0, right = (long) 1e14;
        while (left < right) {
            long mid = (left + right) / 2;
            if (check(mid, time, totalTrips)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean check(long limit, int[] time, long totalTrips) {
        for (int t : time) totalTrips -= limit / t;
        return totalTrips <= 0;
    }
}