class Solution {
    public int[] parent;
    public boolean validPath(int n, int[][] edges, int start, int end) {
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        for(int[] edge : edges) {
            int p1 = findParent(edge[0]);
            int p2 = findParent(edge[1]);
            if(p1 != p2) {
                parent[p1] = p2;
            }
        }
        return findParent(start) == findParent(end);
    }

    private int findParent(int child) {
        return parent[child] == child ? child : (parent[child] = findParent(parent[child]));
    }
}