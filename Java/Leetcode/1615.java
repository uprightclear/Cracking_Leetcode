class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] cnts = new int[n];
        for (int[] r : roads) {
            cnts[r[0]]++;
            cnts[r[1]]++;
            connected[r[0]][r[1]] = true;
            connected[r[1]][r[0]] = true;  // cache if i and j directly connected
        }
        int res = 0;
        for (int i = 0; i < n; i++) 
            for (int j = i + 1; j < n; j++) 
                res = Math.max(res, cnts[i] + cnts[j] - (connected[i][j] ? 1 : 0));  // loop all pairs
        return res;
    }
}