class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // dp[i][j]: the max value if we get j coins from the first i piles
        // dp[i][j] = max{dp[i-1][j-t] + sum(i, t)} sum(i, t): the sum value if we get t coins from pile i
        int[][] dp = new int[1001][2001];
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= piles.size(); i++) {
                List<Integer> p = piles.get(i - 1);
                int sum = 0;
                for (int t = 0; t <= j && t <= p.size(); t++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - t] + sum);
                    if (t < p.size()) {
                        sum += p.get(t);
                    }
                }
            }
        }
        return dp[piles.size()][k];
    }
}