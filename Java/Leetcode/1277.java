//dp
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        // 预处理每一行和每一列
        for (int i = 0; i < m; i++) {
            ans += dp[i][0] = matrix[i][0];
        }
        for (int j = 0; j < n; j++) {
            ans += dp[0][j] = matrix[0][j];
        }
        // 上述过程(0, 0)判断了两次, 如果matrix[0][0] == 1，说明ans多算了一个
        if (matrix[0][0] == 1) {
            ans--;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }
}

//dfs
class Solution {
    int sum = 0;
    int m, n;
    int[][] grid;
    public int countSquares(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        grid = matrix;
        int len = Math.min(m, n);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 1; k <= len; k++) {
                    if(matrix[i][j] == 1) {
                        if(dfs(i, j, k)) sum++;
                        else break;
                    }
                    //dfs(i, j, k);
                }
            }
        }
        return sum;
    }
    
    private boolean dfs(int x, int y, int side) {
        for(int r = x; r < x + side; r++) {
            for(int c = y; c < y + side; c++) {
                if(r >= m || c >= n) return false;
                if(grid[r][c] == 0) return false;
            }
        }
        return true;
    }
}