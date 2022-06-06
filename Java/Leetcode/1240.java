//https://leetcode.cn/problems/tiling-a-rectangle-with-the-fewest-squares/solution/1240-pu-ci-zhuan-dong-tai-gui-hua-by-acw_weian/
class Solution {
    public int tilingRectangle(int n, int m) {
        int INF = 0x3f3f3f3f;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                //如果是正方形
                if(i == j){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = INF;
                //1.横切
                for(int k = 1; k < i; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[k][j] + dp[i - k][j]);
                }
                //2.竖切
                for(int k = 1; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[i][j - k]);
                }
                
                //3.横竖切
                for(int p = 1; p <= Math.min(i, j); p++){
                    for(int k = 1; k <= p; k++){
                        if(p - k <= 0 || j - p <= 0 || i - p + k <= 0 || j - p - k <= 0) continue;
                        dp[i][j] = Math.min(dp[i][j], dp[p - k][j - p] + 
                                                        dp[i - p + k][j - p - k] +
                                                        dp[i - p][p + k] + 2);
                    }
                }
            }
        }
        return dp[n][m];
    }
}