class Solution {
    int[] ans, count;
    List<Set<Integer>> graph;
    int n;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        graph = new ArrayList<>();
        ans = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);

        for(int i = 0; i < n; i++) graph.add(new HashSet<Integer>());
        for(int[] edge :edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int node, int parent) {
        for(int child : graph.get(node)) {
            if(child != parent) {
                dfs(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }

    public void dfs2(int node, int parent) {
        for(int child : graph.get(node)) {
            if(child != parent) {
                ans[child] = ans[node] - count[child] + (n - count[child]);
                dfs2(child, node);
            }
        }
    }


}