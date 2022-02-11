class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < n; i++) {
            if(grid[0][i] == 1) dfs(grid, 0, i);
            if(grid[m - 1][i] == 1) dfs(grid, m - 1, i);
        }
        for(int i = 0; i < m; i++) {
            if(grid[i][0] == 1) dfs(grid, i, 0);
            if(grid[i][n - 1] == 1) dfs(grid, i, n - 1);
        }
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) ans++;
            }
        }
        return ans;
    }
    
    public void dfs(int[][] grid, int x, int y) {
        grid[x][y] = -1;
        for(int i = 0; i < 4; i++) {
            int newx = x + directions[i][0];
            int newy = y + directions[i][1];
            if(newx >= 0 && newx < m && newy >= 0 && newy < n && grid[newx][newy] == 1) {
                dfs(grid, newx, newy);
            }
        }
    }
}