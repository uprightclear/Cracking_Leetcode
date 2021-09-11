class Solution {
    public int[][] generateMatrix(int n) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] ans = new int[n][n];
        ans[0][0] = 1;
        int[] direction = directions[0];
        int[] start = {0, 0};
        int over = 1;
        for(int i = 1; i < n * n; i++){
            int newx = start[0] + direction[0];
            int newy = start[1] + direction[1];
            if(newx >= 0 && newy >= 0 && newx < n && newy < n && ans[newx][newy] == 0){
                ans[newx][newy] = i + 1;
            }else{
                direction = directions[over % 4];
                over++;
                newx = start[0] + direction[0];
                newy = start[1] + direction[1];
                ans[newx][newy] = i + 1;
            }
            start[0] = newx;
            start[1] = newy;
        }
        return ans;
    }
}

class Solution {
    public int[][] generateMatrix(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }
}