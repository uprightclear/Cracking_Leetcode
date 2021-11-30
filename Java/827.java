class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int n = 0;
    public int largestIsland(int[][] grid) {
        n = grid.length;
        int index = 3, res = 0;
        Map<Integer, Integer> area = new HashMap<>();
        for(int x = 0; x < n; x++) for(int y = 0; y < n; y++) {
            if(grid[x][y] == 1) {
                area.put(index, dfs(grid, x, y, index));
                res = Math.max(res, area.get(index++));
            }
        }

        for(int x = 0; x < n; x++) for(int y = 0; y < n; y++) {
            if(grid[x][y] == 0) {
                Set<Integer> seen = new HashSet<>();
                int cur = 1;
                for(int i = 0; i < directions.length; i++) {
                    int newx = x + directions[i][0];
                    int newy = y + directions[i][1];
                    if(valid(newx, newy)) {
                        index = grid[newx][newy];
                        if(index > 1 && seen.add(index)) cur += area.get(index);
                    }
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y, int index) {
        int area = 0;
        grid[x][y] = index;
        for(int i = 0; i < directions.length; i++) {
            int newx = x + directions[i][0];
            int newy = y + directions[i][1];
            if(valid(newx, newy) && grid[newx][newy] == 1) area += dfs(grid, newx, newy, index);
        }
        return area + 1;
    }

    public boolean valid(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}