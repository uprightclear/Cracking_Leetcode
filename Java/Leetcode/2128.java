class Solution {
    int m, n;
    public boolean removeOnes(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < n; i++) {
            if(grid[0][i] == 1) flipColumn(i, grid);
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(grid[i][j] != grid[i][j - 1]) return false;
            }
        }
        return true;
    }
    
    public void flipColumn(int i, int[][] grid) {
        for(int j = 0; j < m; j++) {
            grid[j][i] = 1 - grid[j][i];
        }
    }
}


//better solution
class Solution {
    public boolean removeOnes(int[][] grid) {
        for (int[] g : grid){
            for (int i = 0; i < g.length; i++){
                if (Math.abs(g[i] - grid[0][i]) != Math.abs(g[0] - grid[0][0]))
                    return false;
            }
        }
        return true;
    }
}