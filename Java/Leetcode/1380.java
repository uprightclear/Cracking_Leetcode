class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        boolean found;
        for(int i = 0; i < m; i++) {
            found = true;
            int index = 0;
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] < matrix[i][index]) {
                    index = j;
                }
            }
            for(int k = 0; k < m; k++) {
                if(matrix[i][index] < matrix[k][index]) {
                    found = false;
                    break;
                }
            }
            if(found) ans.add(matrix[i][index]);
        }
        return ans;
    }
}