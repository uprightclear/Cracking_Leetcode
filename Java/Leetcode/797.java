class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int len = graph.length;
        path.add(0);
        dfs(graph, 0, len - 1);
        return res;
    }

    public void dfs(int[][] graph, int cur, int n){
        if(cur == n){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int next : graph[cur]){
            path.add(next);
            dfs(graph, next, n);
            path.remove(path.size() - 1);
        }
    }
}