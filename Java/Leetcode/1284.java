class Solution {
    private static final int[] d = {0, 0, 1, 0, -1, 0};
    public int minFlips(int[][] mat) {
        int start = 0, m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                start |= mat[i][j] << (i * n + j); // convert the matrix to an int.
        Queue<Integer> q = new LinkedList<>(Arrays.asList(start));
        Set<Integer> seen = new HashSet<>(q);
        int step = 0;
        while(!q.isEmpty()){
            for (int sz = q.size(); sz > 0; --sz) {
                int cur = q.poll();
                if (cur == 0) // All 0s matrix found.
                    return step;
                for (int i = 0; i < m; ++i) { // traverse all m * n bits of cur.
                    for (int j = 0; j < n; ++j) {
                        int next = cur;
                        for (int k = 0; k < 5; ++k) { // flip the cell (i, j) and its neighbors.
                            int r = i + d[k], c = j + d[k + 1];
                            if (r >= 0 && r < m && c >= 0 && c < n)
                                next ^= 1 << (r * n + c);
                        }
                        if (seen.add(next)) // seen it before ?
                            q.offer(next); // no, put it into the Queue.
                    }
                }    
            }
            step++;
        }
        return -1; // impossible to get all 0s matrix.
    }
}