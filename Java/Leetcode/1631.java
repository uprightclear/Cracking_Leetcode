class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] effort = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(effort[i], Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, 0, 0});
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int e = top[0], r = top[1], c = top[2];
            if(r == m - 1 && c == n - 1) return e;
            for(int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newEffort = Math.max(e, Math.abs(heights[nr][nc] - heights[r][c]));
                    if(effort[nr][nc] > newEffort) {
                        effort[nr][nc] = newEffort;
                        pq.offer(new int[]{effort[nr][nc], nr, nc});
                    }
                }
            }
        }
        return 0;
    }
}