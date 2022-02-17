class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] indegree = new int[n + 2];
        for(int[] edge : edges) {
            indegree[edge[0]]++;
            if(indegree[edge[0]] == n) return edge[0];
            indegree[edge[1]]++;
            if(indegree[edge[1]] == n) return edge[1];
        }
        return 0;
    }
}