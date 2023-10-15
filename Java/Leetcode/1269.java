class Solution {
    public int numWays(int steps, int arrLen) {
        //n: the furthest index it can reached which can be back
        int n = Math.min(steps / 2 + 1, arrLen);
        int mod = (int)1e9 + 7;
        int[][] dp = new int[steps + 1][n];
        dp[0][0] = 1;

        for(int i = 1; i <= steps; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                if (j < n - 1) dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
            }
        }

        return dp[steps][0];
    }
}