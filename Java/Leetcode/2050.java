class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] a = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            a[i] = new ArrayList<>();
        }
        for(int[] x: relations){
            a[x[0]].add(x[1]);
        }

        Integer[] memo = new Integer[n + 1];
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans = Math.max(dfs(i, memo, a, time), ans);
        }
        return ans;
    }
 

    private int dfs(int curr, Integer[] memo, List<Integer>[] adj, int[] time){
        if(memo[curr] != null){
            return memo[curr];
        }
        int max = 0;
        for(int x: adj[curr]){
            max = Math.max(max, dfs(x, memo, adj, time));
        }
        return memo[curr] = max + time[curr - 1];
    }
}