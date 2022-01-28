class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    int[][] ans;
    Queue<int[]> queue;
    public int[][] highestPeak(int[][] isWater) {
        m = isWater.length;
        n = isWater[0].length;
        ans = new int[m][n];
        queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    ans[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for(int k = 0; k < 4; k++) {
                    int newx = x + directions[k][0];
                    int newy = y + directions[k][1];
                    if(newx >= 0 && newx < m && newy >= 0 && newy < n && ans[newx][newy] == -1) {
                        ans[newx][newy] = ans[x][y] + 1;
                        queue.offer(new int[]{newx, newy});
                    }
                }
            }
        }
        return ans;
    }
}