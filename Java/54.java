class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        boolean[][] used = new boolean[m][n];
        used[0][0] = true;
        int x = 0, y = 0, k = 0;
        res.add(matrix[0][0]);
        for(int i = 1; i < m * n; i++){
            int newx = x + directions[k % 4][0];
            int newy = y + directions[k % 4][1];
            if(newx < 0 || newx == m || newy < 0 || newy == n || used[newx][newy]){
                k++;
                newx = x + directions[k % 4][0];
                newy = y + directions[k % 4][1];
            }
            res.add(matrix[newx][newy]);
            used[newx][newy] = true;
            x = newx;
            y = newy;
        }
        return res;
    }
}