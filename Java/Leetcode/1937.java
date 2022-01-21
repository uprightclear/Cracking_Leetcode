class Solution {
    //dp[i][j] =  points[i][j] + max{dp[i-1][k] - abs(j -k)}
    //dp[i][j]指取(i,j)下标的元素能达到的最大值
    //优化后变成
    //k <= j k在j左边 dp[i][j] =  points[i][j] - j + max{dp[i-1][k] + k}
    //k > j k在j右边 dp[i][j] =  points[i][j] + j + max{dp[i-1][k] - k}
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] pre = new long[n];//记录上一行的值
        //由于某行的dp值只与上一行的值有关，故只需要两个long[n]的数组作为dp数组做状态转移。
        for (int[] point : points) {
            long[] cur = new long[n];//记录这一行的dp值
            long best = Long.MIN_VALUE;
            //正序遍历
            //为何要正序，因为这时是在k在j左边的情况，那么max{dp[i-1][k] + k}中的k可取[0,j]
            for (int j = 0; j < n; j++) {
                best = Math.max(best, pre[j] + j);//相当于max{dp[i-1][k] + k}的操作
                cur[j] = Math.max(cur[j], point[j] - j + best);
            }
            best = Long.MIN_VALUE;
            //倒序遍历
            //为何要倒序，因为这时是k在j右边的情况，那么max{dp[i-1][k] - k}中的k可取[j,n-1]
            for(int j = n - 1;j >= 0;j--){
                best = Math.max(best, pre[j] - j);//再倒序遍历，找上一行最大的dp[i-1][k]-k
                cur[j] = Math.max(cur[j], best + point[j] + j);
            }
            pre = cur;
        }
        return Arrays.stream(pre).max().getAsLong();//在最后一层找最大值
    }
}