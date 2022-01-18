class Solution {
    long dp[];
    public long mostPoints(int[][] questions) {
        dp = new long[questions.length];
        return dfs(questions, 0);
    }
    public long dfs(int[][] Q, int i) {
        if (i >= Q.length) return 0;
        if (dp[i] > 0) return dp[i];
        int points = Q[i][0], jump = Q[i][1];
        return dp[i] = Math.max(dfs(Q, i + 1), points + dfs(Q, i + jump + 1));
    }
}

class Solution {
    public long mostPoints(int[][] questions) {
        //f[i]: if solve question i, the max score can we get
        //f[i] = max(f[j]) + score[i] (forbid[j] + j < i)
        long[] f = new long[questions.length];
        f[0] = questions[0][0];
        TreeMap<Integer, Long> cand = new TreeMap<>();
        cand.put(questions[0][1], f[0]);
        long max = 0;
        for (int i = 1; i < f.length; i++) {
            while (!cand.isEmpty() && cand.firstKey() < i) {
                var e = cand.pollFirstEntry();
                max = Math.max(max, e.getValue());
           }
            f[i] = questions[i][0] + max;
            int key = questions[i][1] + i;
            cand.put(key, Math.max(cand.getOrDefault(key, 0L), f[i]));
       }
        return Arrays.stream(f).max().getAsLong();
   }
 }