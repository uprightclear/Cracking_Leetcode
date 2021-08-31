class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}