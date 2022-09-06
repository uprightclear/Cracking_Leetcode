class Solution {
    public int closedIsland(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == 0)
                    cnt += dfs(i, j, grid);
        return cnt;
    }
    
    private int dfs(int i, int j, int[][] g) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length)
            return 0;
        if (g[i][j] > 0)
            return 1;
        g[i][j] = 2;
        return dfs(i + 1, j, g) * dfs(i - 1, j, g) * dfs(i, j + 1, g) * dfs(i, j - 1, g);
    }
}