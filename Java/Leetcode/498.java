class Solution {
    //upright, downleft
    int[][] directions = {{-1, 1}, {1, -1}};
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int x = 0, y = 0;
        boolean upright = true;
        int index = 0;
        while(index < m * n) {
            ans[index++] = mat[x][y];
            if(upright) {
                int newx = x + directions[0][0];
                int newy = y + directions[0][1];
                if(newx < 0 && newy < n) {
                    upright = !upright;
                    y += 1;
                } else if (newy >= n) {
                    upright = !upright;
                    x += 1;
                } else {
                    x = newx;
                    y = newy;
                }
            } else {
                int newx = x + directions[1][0];
                int newy = y + directions[1][1];
                if(newx < m && newy < 0) {
                    upright = !upright;
                    x += 1;
                } else if (newx >= m) {
                    upright = !upright;
                    y += 1;
                } else {
                    x = newx;
                    y = newy;
                }
            }
        }
        return ans;
    }
}