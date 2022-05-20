class Solution {
    static int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
    //dp[step][i][j] : the property that start from (i, j) with step steps and still on the board
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) {
                        dp[step][i][j] = 1;
                    } else {
                        for (int[] dir : dirs) {
                            int ni = i + dir[0], nj = j + dir[1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                dp[step][i][j] += dp[step - 1][ni][nj] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
}


// as same as the former one but it was iterate backwards
class Solution {
    int [][] direction =new int[][]{{2,1},{-2,1},{2,-1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
   
    public double knightProbability(int N, int K, int r, int c) {
        double [][][] ways = new double[K+1][N][N];
        ways[0][r][c]=1;
        for(int k=1; k<=K;++k){
            for(int i=0; i<N;++i){
                for(int j=0; j<N;++j){
                    for(int [] dir: direction){
                        int oldR = i-dir[0];
                        int oldC = j-dir[1];
                        if(oldR>=0 && oldC>=0 && oldR<N && oldC<N){
                            ways[k][i][j]+=(ways[k-1][oldR][oldC]/8.0);
                        }
                    }
                }
            }
        }
        double res = 0;
        for(int i=0; i<N;++i){
            for(int j=0; j<N;++j){
                res+=ways[K][i][j];
            }
        }
        return res;
    }
}