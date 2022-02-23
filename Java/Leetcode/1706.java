class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int j = 0; j < n; j++) {
            int col = j;  // the initial col of the ball
            for (int[] row : grid) {
                int dir = row[col];
                col += dir;  // move the ball in the current row
                if (col < 0 || col == n || row[col] != dir) {  //judge whether the ball touch the bound or meet 'V'
                    col = -1;
                    break;
                }
            }
            if (col >= 0) {  //the ball successfully reach the bottom
                ans[j] = col;
            }
        }
        return ans;
    }
}