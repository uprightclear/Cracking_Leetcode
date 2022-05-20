// Let dp(i, k) be the best score partioning A[i:] into at most K parts.

class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int len = nums.length;
        double[] preSum = new double[len + 1];
        for(int i = 0; i < len; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        
        double[] dp = new double[len];
        for(int i = 0; i < len; i++) {
            dp[i] = (preSum[len] - preSum[i]) / (len - i);
        }
        
        for(int m = 1; m < k; m++) {
            for(int i = 0; i < len; i++) {
                for(int j = i + 1; j < len; j++) {
                    dp[i] = Math.max(dp[i], (preSum[j] - preSum[i]) / (j - i) + dp[j]);
                }
            }
        }
        return dp[0];
    }
}