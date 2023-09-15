class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DisjointSetUnion dsu = new DisjointSetUnion(n);
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(dist(points, i, j), i, j));
            }
        }
        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge edge1, Edge edge2) {
                return edge1.len - edge2.len;
            }
        });
        int ret = 0, num = 1;
        for (Edge edge : edges) {
            int len = edge.len, x = edge.x, y = edge.y;
            if (dsu.unionSet(x, y)) {
                ret += len;
                num++;
                if (num == n) {
                    break;
                }
            }
        }
        return ret;
    }

    public int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
}

class DisjointSetUnion {
    int[] f;
    int[] rank;
    int n;

    public DisjointSetUnion(int n) {
        this.n = n;
        this.rank = new int[n];
        Arrays.fill(this.rank, 1);
        this.f = new int[n];
        for (int i = 0; i < n; i++) {
            this.f[i] = i;
        }
    }

    public int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
    }

    public boolean unionSet(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx == fy) {
            return false;
        }
        if (rank[fx] < rank[fy]) {
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        rank[fx] += rank[fy];
        f[fy] = fx;
        return true;
    }
}

class Edge {
    int len, x, y;

    public Edge(int len, int x, int y) {
        this.len = len;
        this.x = x;
        this.y = y;
    }
}




class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        // Min-heap to store minimum weight edge at top.
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));;
        
        // Track nodes which are included in MST.
        boolean[] inMST = new boolean[n];
        
        heap.add(new Pair(0, 0));
        int mstCost = 0;
        int edgesUsed = 0;
        
        while (edgesUsed < n) {
            Pair<Integer, Integer> topElement = heap.poll();
            
            int weight = topElement.getKey();
            int currNode = topElement.getValue();
            
            // If node was already included in MST we will discard this edge.
            if (inMST[currNode]) {
                continue;
            }
            
            inMST[currNode] = true;
            mstCost += weight;
            edgesUsed++;
            
            for (int nextNode = 0; nextNode < n; ++nextNode) {
                // If next node is not in MST, then edge from curr node
                // to next node can be pushed in the priority queue.
                if (!inMST[nextNode]) {
                    int nextWeight = Math.abs(points[currNode][0] - points[nextNode][0]) + 
                                     Math.abs(points[currNode][1] - points[nextNode][1]);
        
                    heap.add(new Pair(nextWeight, nextNode));
                }
            }
        }
        
        return mstCost;
    }
}