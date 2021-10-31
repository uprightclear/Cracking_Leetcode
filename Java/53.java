class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int pre = nums[0];
        int res = nums[0];
        for(int i = 1; i < n; i++){
            int cur = Math.max(pre + nums[i], nums[i]);
            res = Math.max(res, cur);
            pre = cur;
        }
        return res;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, localMax = 0;
        for(int i = 0; i < nums.length; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            max = Math.max(max, localMax);
        }
        return max;
    }
}