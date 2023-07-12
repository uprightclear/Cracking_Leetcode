class Solution {
    public int minReorder(int n, int[][] connections) {
		//ajdacency list where int[] will be [dest,cost]
        List<int[]> [] cons = new List[n];
        for(int[] con : connections) {
            if (cons[con[0]] == null) cons[con[0]] = new ArrayList<int[]>();
            if (cons[con[1]] == null) cons[con[1]] = new ArrayList<int[]>();
            cons[con[0]].add(new int[]{con[1],1});//original direction, costs 1
            cons[con[1]].add(new int[]{con[0],0});//oposite directions, costs 0
        }
        return dfs(0, cons, new boolean[n]);

    }

    private int dfs(int curr, List<int[]>[] cons, boolean[] visited) {
        int cost = 0;
        visited[curr] = true; /* marking visited */
        for(int[] neigh : cons[curr]) {
            if (!visited[neigh[0]]) {
                cost += neigh[1];
                cost += dfs(neigh[0], cons, visited);
            }
        }
        return cost;
    }
}