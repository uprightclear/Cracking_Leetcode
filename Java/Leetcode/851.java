//DFS
class Solution {
    HashMap<Integer, List<Integer>> richer2 = new HashMap<>();
    int res[];
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        for (int i = 0; i < n; ++i) richer2.put(i, new ArrayList<Integer>());
        for (int[] v : richer) richer2.get(v[1]).add(v[0]);
        res = new int[n]; Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) dfs(i, quiet);
        return res;
    }

    int dfs(int i, int[] quiet) {
        if (res[i] >= 0) return res[i];
        res[i] = i;
        for (int j : richer2.get(i)) if (quiet[res[i]] > quiet[dfs(j, quiet)]) res[i] = res[j];
        return res[i];
    }
}



//Topo sort
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int len = quiet.length;
        int[] indegree = new int[len];
        Map<Integer, Set<Integer>> map = new HashMap();
        for(int[] r : richer){
            map.putIfAbsent(r[0], new HashSet());
            map.get(r[0]).add(r[1]);
            indegree[r[1]]++;
        }
        Queue<Integer> q = new LinkedList();
        int[] res = new int[len];
        for(int i=0; i<len; i++){
            res[i] = i;
            if(indegree[i]==0)
                q.offer(i);
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int m=0; m<size; m++){
                int cur = q.poll();
                if(map.containsKey(cur)){
                    for(int next : map.get(cur)){
                        if(quiet[res[next]] > quiet[res[cur]])
                            res[next] = res[cur];
                        if(--indegree[next] == 0)
                            q.offer(next);
                    }
                }
            }
        }
        return res;
    }
}