class Solution {
    int ans = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; ++i) adj[i] = new LinkedList();
        for (int[] e : edges) {
            int i = e[0], j = e[1], t = e[2];
            adj[i].add(new int[]{j, t});
            adj[j].add(new int[]{i, t});
        }
        int[] seen = new int[n];
        seen[0]++;
        dfs(adj, 0, values, maxTime, seen, values[0]);
        return ans;
    }
    
    private void dfs(List<int[]>[] adj, int src, int[] values, int maxTime, int[] seen, int sum) {
        if (0 == src) {
            ans = Math.max(ans, sum);
        }
        if (0 > maxTime) return;
        for (int[] data : adj[src]) {
            int dst = data[0], t = data[1];
            if (0 > maxTime - t) continue;
            seen[dst]++;
            dfs(adj, dst, values, maxTime - t, seen, sum + (1 == seen[dst] ? values[dst] : 0));
            seen[dst]--;
        }
    }
}