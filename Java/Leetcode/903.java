class Solution {
    public int numPermsDISequence(String s) {
        int n = s.length(), MOD = (int)1e9 + 7;
        int[][] dp = new int[n + 1][n + 1];
        for(int j = 0; j <= n; j++) dp[0][j] = 1;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'I') {
                for(int j = 0, cur = 0; j < n - i; j++) {
                    dp[i + 1][j] = cur = (cur + dp[i][j]) % MOD;
                }
            } else {
                for(int j = n - i - 1, cur = 0; j >= 0; j--) {
                    dp[i + 1][j] = cur = (cur + dp[i][j + 1]) % MOD;
                }
            }
        }
        return dp[n][0];
    }
}

//https://leetcode.com/problems/valid-permutations-for-di-sequence/discuss/168278/C%2B%2BJavaPython-DP-Solution-O(N2)