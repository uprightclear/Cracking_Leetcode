class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        //从x到y的距离
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        //k到其他点的距离（到其本身的距离为0）
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            //从未确定节点中取一个与起点距离最短的点
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}

//堆优化
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int max = 0x3f3f3f3f;
        List<int[]>[] g = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<int[]>();
        }
        
        for (int[] x : times) {
            int a = x[0], b = x[1], c = x[2];
            g[a].add(new int[]{b, c});
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1,o2) -> o1[0] - o2[0]);
        heap.add(new int[]{0, k});
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, max);
        boolean[] v = new boolean[n + 1];
        dist[k] = 0;

        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            int distance = poll[0], t = poll[1];
            // 一个点可能被多次更新, 堆中可能有多个相同的点, 只需要用该点更新一次其他店即可
            if (v[t]) continue;
            v[t] = true;
            
            for (int[] x : g[t]) {
                int a = x[0], w = x[1];
                if (dist[a] > distance + w) {
                    dist[a] = distance + w;
                    heap.add(new int[]{dist[a], a});
                }
            }
        }
 
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) return -1;
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] time : times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        
        //distance, node into pq
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        
        pq.add(new int[]{0, K});
        
        boolean[] visited = new boolean[N+1];
        int res = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int curNode = cur[1];
            int curDist = cur[0];
            if(visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if(map.containsKey(curNode)){
                for(int next : map.get(curNode).keySet()){
                    pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }
        return N == 0 ? res : -1;
            
    }
}