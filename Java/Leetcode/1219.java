class Solution {
    int[][] grid;
    int m, n, ans;
    int dirx[] = {-1, 1, 0, 0};
    int diry[] = {0, 0, -1, 1};

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    int temp = grid[i][j];
                    grid[i][j] = 0;
                    dfs(i, j, temp);
                    grid[i][j] = temp;
                }
            }    
        }
        return ans;
    }
  	
    public int dfs(int x, int y, int sum) {
        ans = Math.max(ans, sum);
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dirx[i];
            int ny = y + diry[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] > 0) {
                int temp = grid[nx][ny];
                grid[nx][ny] = 0;
                dfs(nx, ny, sum + temp);
                grid[nx][ny] = temp;
            }
        }

        return sum;
    }
}