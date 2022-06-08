class Solution {
    int[][] moves = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}};
    public int minPushBox(char[][] grid) {
        int[] box = null, target = null, storekeeper = null;
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
            if (grid[i][j] == 'B') box = new int[]{i, j};
            else if (grid[i][j] == 'T') target = new int[]{i, j};
            else if (grid[i][j] == 'S') storekeeper = new int[]{i, j};
        }
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> dis = new HashMap<>();
        int start = encode(box[0], box[1], storekeeper[0], storekeeper[1]);
        dis.put(start, 0);
        q.offer(start);
        int ret = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int u = q.poll();
            int[] du = decode(u);
            if (dis.get(u) >= ret) continue;
            if (du[0] == target[0] && du[1] == target[1]) {
                ret = Math.min(ret, dis.get(u));
                continue;
            }
            int[] b = new int[]{du[0], du[1]};
            int[] s = new int[]{du[2], du[3]};
			// move the storekeeper for 1 step
            for (int[] move : moves) {
                int nsx = s[0] + move[0];
                int nsy = s[1] + move[1];
                if (nsx < 0 || nsx >= n || nsy < 0 || nsy >= m || grid[nsx][nsy] == '#') continue;
				// if it meet the box, then the box move in the same direction
                if (nsx == b[0] && nsy == b[1]) {
                    int nbx = b[0] + move[0];
                    int nby = b[1] + move[1];
                    if (nbx < 0 || nbx >= n || nby < 0 || nby >= m || grid[nbx][nby] == '#') continue;
                    int v = encode(nbx, nby, nsx, nsy);
                    if (dis.containsKey(v) && dis.get(v) <= dis.get(u) + 1) continue;
                    dis.put(v, dis.get(u) + 1);
                    q.offer(v);
                } else { // if the storekeeper doesn't meet the box, the position of the box do not change
                    int v = encode(b[0], b[1], nsx, nsy);
                    if (dis.containsKey(v) && dis.get(v) <= dis.get(u)) continue;
                    dis.put(v, dis.get(u));
                    q.offer(v);
                }
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
    int encode(int bx, int by, int sx, int sy) {
        return (bx << 24) | (by << 16) | (sx << 8) | sy;
    }
    int[] decode(int num) {
        int[] ret = new int[4];
        ret[0] = (num >>> 24) & 0xff;
        ret[1] = (num >>> 16) & 0xff;
        ret[2] = (num >>> 8) & 0xff;
        ret[3] = num & 0xff;
        return ret;
    }
}