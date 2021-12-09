public class Solution {
    /**
     * @param flights: the airline status from the city i to the city j
     * @param days: days[i][j] represents the maximum days you could take vacation in the city i in the week j
     * @return: the maximum vacation days you could take during K weeks
     */
    public int maxVacationDays(int[][] flights, int[][] days) {
        // Write your code here
        int N = flights.length;
        int K = days[0].length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < K; i++) {			//逐渐扩大枚举周
            int[] temp = new int[N];
            Arrays.fill(temp, Integer.MIN_VALUE);
            for (int j = 0; j < N; j++) {			//枚举终点
                for(int k = 0; k < N; k++) {			//枚举起点
                    if (j == k || flights[k][j] == 1) {			//如果城市k到城市j存在航班
                        temp[j] = Math.max(temp[j], dp[k] + days[j][i]);		//则再对当前答案进行选择，即是否从k前往j
                    }
                }
            }
            dp = temp;
        }
        
        int ans = 0;
        for(int i = 0; i < N; i++){			//最后对dp数组筛选最大值即可
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}