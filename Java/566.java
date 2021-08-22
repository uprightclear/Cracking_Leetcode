class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(m * n == r * c){
            int num = m * n;
            int[][] res = new int[r][c];
            for(int i = 0; i < num; i++){
                res[i / c][i % c] = mat[i / n][i % n];
            }
            return res;
        }
        return mat;
    }
}