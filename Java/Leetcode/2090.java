class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k == 0) return nums;
        int len = nums.length;
        long[] preSum = new long[len];
        preSum[0] = nums[0];
        for(int i = 1; i < len; i++) preSum[i] = preSum[i - 1] + nums[i];
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        if(2 * k + 1 > len) return ans;
        for(int i = k; i < len - k; i++) {
            long sum = 0;
            if(i - k == 0) sum = preSum[i + k];
            else sum = preSum[i + k] - preSum[i - k - 1];
            ans[i] = (int) (sum / (long) (2 * k + 1));
        }
        return ans;
    }
}