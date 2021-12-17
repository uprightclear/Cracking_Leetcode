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