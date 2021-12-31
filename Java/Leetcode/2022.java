class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if(m * n != len) return new int[0][0];
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++) {
            int[] tmp = new int[n];
            for(int j = 0; j < n; j++) {
                tmp[j] = original[i * n + j];
            }
            ans[i] = tmp;
        }
        return ans;
    }
}