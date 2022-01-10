class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n; ++r) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int c = 0; c < n; ++c) {
                if(!row.add(matrix[r][c])) return false;
                if(!col.add(matrix[c][r])) return false;
            }
        }
        return true;
    }
}