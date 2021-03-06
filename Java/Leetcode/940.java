class Solution {
    public int distinctSubseqII(String S) {
        int MOD = (int) 1e9 + 7;
        int N = S.length();
        //dp[i]: the number of sub till the ending with index i - 1
        int[] dp = new int[N + 1];
        dp[0] = 1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < N; ++i) {
            int x = S.charAt(i) - 'a';
            dp[i + 1] = dp[i] * 2 % MOD;
            if (last[x] >= 0)
                dp[i + 1] -= dp[last[x]];
            dp[i + 1] %= MOD;
            last[x] = i;
        }
        //减掉空字符串
        dp[N]--;
        if (dp[N] < 0) dp[N] += MOD;
        return dp[N];
    }
}