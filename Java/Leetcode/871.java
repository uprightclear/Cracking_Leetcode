//dp[i]: the farthest location we can get to using i refueling stops.
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for (int i = 0; i < N; ++i)
            for (int t = i; t >= 0; --t)
                if (dp[t] >= stations[i][0])
                    dp[t + 1] = Math.max(dp[t + 1], dp[t] + (long) stations[i][1]);

        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target) return i;
        return -1;
    }
}


class Solution {
    public int minRefuelStops(int t, int start, int[][] ss) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int n = ss.length, idx = 0;
        int remain = start, loc = 0, ans = 0;
        while (loc < t) {
            if (remain == 0) {
                if (!q.isEmpty() && ++ans >= 0) remain += q.poll();
                else return -1;
            }
            loc += remain; remain = 0;
            while (idx < n && ss[idx][0] <= loc) q.add(ss[idx++][1]);
        }
        return ans;
    }
}