class TicTacToe {
    int[][] matrix;
    public TicTacToe(int n) {
        matrix = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        matrix[row][col] = player;
        if(checkRow(row, player) || checkCol(col, player)) return player;
        if(row == col) {
            if(checkDiag(player)) return player;
        }
        if(row + col == matrix.length - 1) {
            if(checkDiag2(player)) return player;
        }
        return 0;
    }
    
    public boolean checkRow(int row, int player) {
        for(int ele : matrix[row]) {
            if(ele != player) return false;
        }
        return true;
    }
    
    public boolean checkCol(int col, int player) {
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][col] != player) return false;
        }
        return true;
    }
    
    public boolean checkDiag(int player) {
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][i] != player) return false;
        }
        return true;
    }
    
    public boolean checkDiag2(int player) {
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][matrix.length - 1 - i] != player) return false;
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */



public class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        // update currentPlayer in rows and cols arrays
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;
        // update diagonal
        if (row == col) {
            diagonal += currentPlayer;
        }
        //update anti diagonal
        if (col == (cols.length - row - 1)) {
            antiDiagonal += currentPlayer;
        }
        int n = rows.length;
        // check if the current player wins
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }
        // No one wins
        return 0;
    }
}
