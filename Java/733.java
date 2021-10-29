class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int newColor;
    int ori;
    int m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        ori = image[sr][sc];
        if(ori == newColor) return image;
        this.newColor = newColor;
        dfs(image, sr, sc);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc) {
        image[sr][sc] = newColor;
        for(int i = 0; i < 4; i++) {
            int nr = sr + directions[i][0];
            int nc = sc + directions[i][1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == ori) {
                dfs(image, nr, nc);
            }
        }
        return;
    }
}