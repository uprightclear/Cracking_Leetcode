class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0] > 0 ? 1 : 0;
        //dp[i][0]：以nums[i]结尾的负数乘机的最大长度
        //dp[i][1]：以nums[i]结尾的正数乘机的最大长度
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0] < 0 ? 1 : 0;
        dp[0][1] = nums[0] > 0 ? 1 : 0;
        int res = dp[0][1];
        for(int i = 1; i < n; i++){
            if(nums[i] > 0){
                dp[i][0] = dp[i - 1][0] == 0 ? 0 : dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            }else if(nums[i] < 0){
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][0] == 0 ? 0 : dp[i - 1][0] + 1;
            }
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}

//空间优化
class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0] > 0 ? 1 : 0;
        //dp[i][0]：以nums[i]结尾的负数乘机的最大长度
        //dp[i][1]：以nums[i]结尾的正数乘机的最大长度
        //int[][] dp = new int[n][2];
        int negative = nums[0] < 0 ? 1 : 0;
        int posative = nums[0] > 0 ? 1 : 0;
        int res = posative;
        for(int i = 1; i < n; i++){
            int neg = negative, pos = posative;
            if(nums[i] > 0){
                negative = neg == 0 ? 0 : neg + 1;
                posative = pos + 1;
            }else if(nums[i] < 0){
                negative = pos + 1;
                posative = neg == 0 ? 0 : neg + 1;
            }else{
                negative = 0;
                posative = 0;
            }
            res = Math.max(res, posative);
        }
        return res;
    }
}