class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                int diff = days[i] - days[j] + 1;
                dp[i] = Math.min(dp[i - 1] + dp[0], dp[i]);
                if(diff <= 7) dp[i] = j == 0 ? Math.min(dp[i], costs[1]) : Math.min(dp[i], dp[j - 1] + costs[1]);
                if(diff <= 30) dp[i] = j == 0 ? Math.min(dp[i], costs[2]) : Math.min(dp[i], dp[j - 1] + costs[2]);
            }
        }
        return dp[n - 1];
    }
}