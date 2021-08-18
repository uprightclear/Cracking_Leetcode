class Solution {
    private int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int m, n;
    int ans = 0;
    int sum = 0;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(grid, i, j);
                sum = 0;
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int x, int y){
        if(grid[x][y] == 1){
            sum ++;
            grid[x][y] = 2;
            for(int i = 0; i < 4; i++){
                int newx = x + direction[i][0], newy = y + direction[i][1];
                if(newx >= 0 && newx < m && newy >= 0 && newy < n) dfs(grid, newx, newy);
            }
            ans = Math.max(ans, sum);
        }
    }
}

//BFS
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                int cur = 0;
                Queue<Integer> queuei = new LinkedList<Integer>();
                Queue<Integer> queuej = new LinkedList<Integer>();
                queuei.offer(i);
                queuej.offer(j);
                while (!queuei.isEmpty()) {
                    int cur_i = queuei.poll(), cur_j = queuej.poll();
                    if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
                        continue;
                    }
                    ++cur;
                    grid[cur_i][cur_j] = 0;
                    int[] di = {0, 0, 1, -1};
                    int[] dj = {1, -1, 0, 0};
                    for (int index = 0; index != 4; ++index) {
                        int next_i = cur_i + di[index], next_j = cur_j + dj[index];
                        queuei.offer(next_i);
                        queuej.offer(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }
}