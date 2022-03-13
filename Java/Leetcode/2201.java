class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int[][] map = new int[n][n];
        for(int[] p : dig) map[p[0]][p[1]] = 1;
        
        int[][] preSum = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                preSum[i][j] = map[i - 1][j - 1] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }
        
        int res = 0;
        for(int[] p : artifacts) {
            int sum = preSum[p[2] + 1][p[3] + 1] - preSum[p[2] + 1][p[1]] - preSum[p[0]][p[3] + 1] + preSum[p[0]][p[1]];
            int real = (p[3] - p[1] + 1) * (p[2] - p[0] + 1);
            if(sum == real) res++;
        }
        
        return res;
    }
}