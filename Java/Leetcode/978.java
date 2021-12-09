//dp
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        //dp[i][0]:increase, dp[i][1]:decrease
        int[][] dp = new int[len][2];
        for(int[] each : dp) Arrays.fill(each, 1);
        int res = 1;
        for(int i = 1; i < len; i++){
            if(arr[i] == arr[i - 1]){
                continue;
            }else if(arr[i] > arr[i - 1]){
                dp[i][0] = dp[i - 1][1] + 1;
                res = Math.max(dp[i][0], res);
            }else if(arr[i] < arr[i - 1]){
                dp[i][1] = dp[i - 1][0] + 1;
                res = Math.max(dp[i][1], res);
            }
        }
        return res;
    }
}

//sliding window
class Solution {
    public int maxTurbulenceSize(int[] A) {
        int N = A.length;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < N; ++i) {
            int c = Integer.compare(A[i-1], A[i]);
            if (c == 0) {
                anchor = i;
            } else if (i == N-1 || c * Integer.compare(A[i], A[i+1]) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }

        return ans;
    }
}