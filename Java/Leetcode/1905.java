class Solution {
    boolean flag;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;

        int delRow[] = {1, -1, 0, 0};
        int delCol[] = {0, 0, 1, -1};

        int sub = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid2[i][j] == 1){
                    if(dfs(i, j, grid1, grid2, delRow, delCol)) sub++;
                }
            }
        }
        return sub;
    }

    public boolean dfs(int i,int j, int[][] grid1, int[][] grid2, int delRow[], int delCol[]){
        if(grid1[i][j] == 0) {
            return false;
        }

        grid2[i][j] = 0;
        int m = grid2.length;
        int n = grid2[0].length;
        boolean res = true;
        for(int k = 0; k < 4; k++){
            int nrow = i + delRow[k];
            int ncol = j + delCol[k];
            if(nrow < m && ncol < n && nrow >= 0 && ncol >= 0 && grid2[nrow][ncol] == 1){
                res &= dfs(nrow, ncol, grid1, grid2, delRow, delCol);
            }
        }
        return res;
    }
}