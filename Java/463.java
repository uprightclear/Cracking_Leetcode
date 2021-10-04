class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    ans += peri(grid, i, j);
                }
            }
        }
        return ans;
    }
    
    private int peri(int[][] grid, int x, int y){
        int count = 4;
        for(int k = 0; k < 4; k++) {
            int newx = x + directions[k][0];
            int newy = y + directions[k][1];
            if(newx >= 0 && newx < m && newy >= 0 && newy < n && grid[newx][newy] == 1) {
                count--;
            } 
        }
        return count;
    }
}



class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int result = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    result += 4;
                    
                    if (r > 0 && grid[r-1][c] == 1) {
                        result -= 2;
                    }
                    
                    if (c > 0 && grid[r][c-1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        
        return result;
    }
}