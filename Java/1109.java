//差分 + 前缀和
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

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int len = bookings.length;
        for(int i = 0; i < len; i++) {
            for(int j = bookings[i][0]; j <= bookings[i][1]; j++) {
                ans[j - 1] += bookings[i][2];
            }
        }
        return ans;
    }
}