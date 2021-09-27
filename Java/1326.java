class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] prev = new int[n + 1];
        for(int i = 0; i <= n; i++) prev[i] = i; 
        
        for(int i = 0; i <= n; i++) {
            int l = Math.max(i - ranges[i], 0);
            int r = Math.min(i + ranges[i], n);
            prev[r] = Math.min(prev[r], l);
        }
        
        int[] dp = new int[n + 1];
        //到有边界i为止所需要的最少taps
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1; i <= n; i++) {
            for(int j = prev[i]; j < i; j++) {
                if(dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}