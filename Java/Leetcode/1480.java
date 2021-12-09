class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + dp[i - 1];
        }
        return dp;
    }
}