class Solution {
    public int maxProfit(int[] prices) {
        //dp[i][0]:当前持有一股能获得的最大利润
        //dp[i][1]:当前持有零股当天卖掉
        //dp[i][2]:当前持有零股非当天卖掉

        //dp[i][0] = max(dp[i-1][0], dp[i-1][2]-prices[i])
        //dp[i][1] = dp[i-1][0] + prices[i]
        //dp[i][2] = max(dp[i-1][1], dp[i-1][2]) 

        //dp[0][0] = 0 - prices[0]
        //dp[0][1] = 0
        //dp[0][2] = 0

        int n = prices.length;
        if(n == 0){
            return 0;
        }
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) ;
        }
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }
}