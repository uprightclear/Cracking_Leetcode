class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int[] x = new int[n];
        int[] y = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) res++;
                x[i] = Math.max(x[i], grid[i][j]);
                y[j] = Math.max(y[j], grid[i][j]);
            }
        }
        res += Arrays.stream(x).sum() + Arrays.stream(y).sum();
        return res;
    }
}