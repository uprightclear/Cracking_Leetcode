class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int[] preNumOf1 = new int[len + 1];
        for(int i = 1; i <= len; i++) {
            preNumOf1[i] = preNumOf1[i - 1] + (s.charAt(i - 1) == '1' ? 1 : 0);
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= len; i++) {
            ans = Math.min(ans, preNumOf1[i] + (len - i - (preNumOf1[len] - preNumOf1[i])));
        }
        return ans;
    }
}

class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '0' ? 1 : 0;
        for(int i = 1; i < n; i++) {
            dp[i][0] = s.charAt(i) == '0' ? dp[i - 1][0] : dp[i - 1][0] + 1;
            dp[i][1] = s.charAt(i) == '0' ? Math.min(dp[i - 1][1], dp[i - 1][0]) + 1 : Math.min(dp[i - 1][1], dp[i - 1][0]);
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}