class Solution {
    public long maximumSumScore(int[] nums) {
        long[] preSum = new long[nums.length];
        preSum[0] = (long)nums[0];
        for(int i = 1; i < nums.length; i++) {
            preSum[i] = (long)nums[i] + preSum[i - 1];
        }
        long sum = preSum[nums.length - 1];
        long ans = Long.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            long cur = Math.max(preSum[i], sum - preSum[i] + nums[i]);
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}