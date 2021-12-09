class Solution {
    static class Edge {
        int to;
        long len;
        Edge(int _to, long _len) {
            to = _to;
            len = _len;
        }
    }

    List<Edge>[] graph;
    // INF 不能是经典的 0x3f3f3f3f，要变大！
    final long INF = Long.MAX_VALUE;
    final int MOD = (int)1e9 + 7;

    private int dijkstra(int ed) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Long.compare(a.len, b.len));
        boolean[] vis = new boolean[ed];
        long[] dist = new long[ed];
        int[] cnt = new int[ed];

        pq.offer(new Edge(0, 0));
        Arrays.fill(dist, INF);
        dist[0] = 0;
        cnt[0] = 1;
        
        while (!pq.isEmpty()) {
            int u = pq.poll().to;
            if (vis[u]) {
                continue;
            }
            vis[u] = true;
            for (Edge next : graph[u]) {
                int v = next.to;
                long w = next.len;
                if (dist[v] > dist[u] + w) {
                    // 新的最短路继承前驱的最短路径条数
                    cnt[v] = cnt[u];
                    dist[v] = dist[u] + w;
                    pq.offer(new Edge(v, dist[v]));
                } else if (dist[v] == dist[u] + w) {
                    // 相同的最短路走法（指走到 v）则进行累加
                    // 不要忘记取模
                    cnt[v] = (cnt[v] + cnt[u]) % MOD;
                }
            }
        }

        return cnt[ed - 1];
    }

    public int countPaths(int n, int[][] roads) {
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : roads) {
            int u = p[0], v = p[1], w = p[2];
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        return dijkstra(n);
    }
}