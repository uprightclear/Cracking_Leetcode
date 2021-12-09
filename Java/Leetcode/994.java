class Solution {
    int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0, orange = 0;
        Queue<int[]> queue = new LinkedList<>(); 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    orange++;
                }
            }
        }

        if(orange == 0) return 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            for(int i = 0; i < size; i++){
                int[] rot = queue.poll();
                int x = rot[0], y = rot[1];
                for(int k = 0; k < 4; k++){
                    int nx = x + direction[k][0], ny = y + direction[k][1];
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 1) continue;
                    grid[nx][ny] = 2;
                    orange--;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        if(orange > 0) return -1;
        return res - 1;
    }
}