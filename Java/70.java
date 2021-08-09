class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

//滚动数组将空间复杂度优化到o(1)
class Solution {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for(int i = 1; i <= n; i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}