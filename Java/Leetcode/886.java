class Solution {
    public boolean bfs(int source, Map<Integer, List<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        color[source] = 0; // Start with marking source as `RED`.

        while (!q.isEmpty()) {
            int node = q.poll();
            if (!adj.containsKey(node))
                continue;
            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == color[node])
                    return false;
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : dislikes) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1); // 0 stands for red and 1 stands for blue.

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                // For each pending component, run BFS.
                if (!bfs(i, adj, color))
                    // Return false, if there is conflict in the component.
                    return false;
            }
        }
        return true;
    }
}