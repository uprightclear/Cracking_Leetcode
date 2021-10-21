class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row_visited = new boolean[m];
        boolean[] col_visited = new boolean[n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!row_visited[i] && matrix[i][j] == 0) {//deal row
                    row_visited[i] = true;
                }
                if(!col_visited[j] && matrix[i][j] == 0) {//deal col
                    col_visited[j] = true;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            if(row_visited[i] == true) {
                for(int k = 0; k < n; k++) matrix[i][k] = 0;
            }
        }
        for(int i = 0; i < n; i++) {
            if(col_visited[i] == true) {
                for(int k = 0; k < m; k++) matrix[k][i] = 0;
            }
        }
    }
}

//space complexity o(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0_flag = false;
        boolean col0_flag = false;
        // 第一行是否有零
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                row0_flag = true;
                break;
            }
        }
        // 第一列是否有零
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0_flag = true;
                break;
            }
        }
        // 把第一行第一列作为标志位
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 置0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0_flag) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0_flag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        } 
    }
}