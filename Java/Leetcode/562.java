class Solution {
    public int longestLine(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][][] dp = new int[m][n][4];
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) continue;
                for(int k = 0; k < 4; k++) dp[i][j][k] = 1;
                if(j > 0) dp[i][j][0] = dp[i][j - 1][0] + 1; // horizontal
                if(j > 0 && i > 0) dp[i][j][1] = dp[i - 1][j - 1][1] + 1; //anti-diagonal
                if(i > 0) dp[i][j][2] = dp[i - 1][j][2] + 1; //vertical
                if(j < n - 1 && i > 0) dp[i][j][3] = dp[i - 1][j + 1][3] + 1; //diagonal
                ans = Math.max(ans, Math.max(dp[i][j][0], dp[i][j][1]));
                ans = Math.max(ans, Math.max(dp[i][j][2], dp[i][j][3]));
            }
        }
        return ans;
    }
}