// Naive DFS Solution
// Time Limit Exceeded
public class Solution {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
  
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(matrix, i, j));
        return ans;
    }
  
    private int dfs(int[][] matrix, int i, int j) {
        int ans = 0;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
                ans = Math.max(ans, dfs(matrix, x, y));
        }
        return ++ans;
    }
  }

// DFS + Memoization Solution
// Accepted and Recommended
class Solution {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        if(m == 0) return 0;
        int[][] cache = new int[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, cache));
            }
        }
        return ans;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if(cache[i][j] != 0) return cache[i][j];
        cache[i][j] = 1;
        for(int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if(0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], 1 + dfs(matrix, x, y, cache));
            }
        }
        return cache[i][j];
    }
}