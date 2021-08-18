class Solution {
    private int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        int oriColor = image[sr][sc];
        if(oriColor != newColor) dfs(image, sr, sc, oriColor, newColor);
        return image;
    }

    public void dfs(int[][] image, int x, int y, int oriColor, int newColor){
        if(image[x][y] == oriColor){
            image[x][y] = newColor;
            for(int i = 0; i < 4; i++){
                int newx = x + direction[i][0], newy = y + direction[i][1];
                if(newx >= 0 && newx < m && newy >= 0 && newy < n) dfs(image, newx, newy, oriColor, newColor);
            }
        }
    }
}

//BFS
class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }
}