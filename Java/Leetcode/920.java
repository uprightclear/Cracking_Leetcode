class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        int MOD = (int) 1e9 + 7;
        //dp[i][j]: the playlist counts with length of i and end with j
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= goal; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] += dp[i - 1][j - 1] * (n - j + 1);//end with new song
                dp[i][j] += dp[i - 1][j] * Math.max(j - k, 0);//end with used song
                dp[i][j] %= MOD;
            }
        }
        return (int) dp[goal][n];
    }
}