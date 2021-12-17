class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    int m, n;
    public int countBattleships(char[][] board) {
        m = board.length;
        n = board[0].length;
        int ans = 0;
        for(int i  = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'X') {
                    ans++;
                    dfs(i, j, board);
                }
            }
        }
        return ans;
    }

    private void dfs(int x, int y, char[][] board) {
        board[x][y] = '.';
        for(int i = 0; i < 4; i++) {
            int newx = x + directions[i][0];
            int newy = y + directions[i][1];
            if(newx >= 0 && newx < m && newy >= 0 && newy < n && board[newx][newy] == 'X') dfs(newx, newy, board);
        }
    }
}

//follow up(without changing orinal matrix)
class Solution {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int ans = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    //if the current node's up and current node's left is not 'X'
                    //or the current node is on the boundary;
                    ans++;
                }
            }
        }
        return ans;
    }
}