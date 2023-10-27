class Solution {
    Map<Integer, Integer> m = new HashMap<>();
    int[][] dp;

    boolean solve(int i, int k, int[] stones) {
        if (i == stones.length - 1) {
            return true;
        }

        if (dp[i][k] != -1) {
            return dp[i][k] == 1;
        }

        boolean k0 = false, kp = false, k1 = false;

        if (m.containsKey(stones[i] + k)) {
            k0 = solve(m.get(stones[i] + k), k, stones);
        }
        if (k > 1 && m.containsKey(stones[i] + k - 1)) {
            kp = solve(m.get(stones[i] + k - 1), k - 1, stones);
        }
        if (m.containsKey(stones[i] + k + 1)) {
            k1 = solve(m.get(stones[i] + k + 1), k + 1, stones);
        }

        dp[i][k] = (k0 || kp || k1) ? 1 : 0;
        return dp[i][k] == 1;
    }

    public boolean canCross(int[] stones) {
        if (stones[1] - stones[0] != 1) {
            return false;
        }

        for (int i = 0; i < stones.length; i++) {
            m.put(stones[i], i);
        }

        dp = new int[stones.length][stones.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(1, 1, stones);
    }
}