class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for(int i = 0; i < parent.length; i++) parent[i] = i;
        for(int[] edge : edges) {
            if(find(edge[0]) == find(edge[1])) return edge;
            else union(edge[0], edge[1]);
        }
        return edges[0];
    }

    public int find(int x) {
        if(x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        parent[find(y)] = find(x);
    }
}