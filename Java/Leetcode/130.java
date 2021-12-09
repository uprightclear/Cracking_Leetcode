class Solution {
    int[] dx={1,-1,0,0};
    int[] dy={0,0,1,-1};
    public void solve(char[][] board) {
        //遍历边上的O
        //这里可以只遍历四条边，但是好像影响不大。
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if((i==0||j==0||i==board.length-1||j==board[0].length-1)&&board[i][j]=='O'){
                    helper(board,i,j);
                }
            }
        }
        //把K改成O，其他改成X
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=board[i][j]=='K'?'O':'X';
            }
        }
    }
    void helper(char[][] board,int i,int j){
        board[i][j]='K';
        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if(x>=0&&y>=0&&x<board.length&&y<board[0].length&&board[x][y]=='O'){
                helper(board,x,y);
            }
        }
    }
}
