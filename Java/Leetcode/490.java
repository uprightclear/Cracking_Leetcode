class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }
    
    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if(visited[start[0]][start[1]]) return false;
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        visited[start[0]][start[1]] = true;
        int r = start[1] + 1, l = start[1] - 1, u = start[0] - 1, d = start[0] + 1;
        while (r < maze[0].length && maze[start[0]][r] == 0) // right
            r++;
            if (dfs(maze, new int[] {start[0], r - 1}, destination, visited))
                return true;
        while (l >= 0 && maze[start[0]][l] == 0) //left
            l--;
            if (dfs(maze, new int[] {start[0], l + 1}, destination, visited))
                return true;
        while (u >= 0 && maze[u][start[1]] == 0) //up
            u--;
            if (dfs(maze, new int[] {u + 1, start[1]}, destination, visited))
                return true;
        while (d < maze.length && maze[d][start[1]] == 0) //down
            d++;
            if (dfs(maze, new int[] {d - 1, start[1]}, destination, visited))
                return true;
        return false;
    }
}


class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        visited = new boolean[m][n];
        return dfs(maze, start[0], start[1], destination);
    }

    public boolean dfs(int[][] maze, int row, int col, int[] destination) {
        if(visited[row][col]) return false;
        if(row == destination[0] && col == destination[1]) return true;
        visited[row][col] = true;
        for(int[] dir : directions) {
            int newRow = row;
            int newCol = col;
            while(newRow + dir[0] < m && newRow + dir[0] >= 0 && newCol + dir[1] < n && newCol + dir[1] >= 0 && maze[newRow + dir[0]][newCol + dir[1]] != 1) {
                newRow += dir[0];
                newCol += dir[1];
            }
            if(dfs(maze, newRow, newCol, destination)) return true;
        }
        return false;
    }
}