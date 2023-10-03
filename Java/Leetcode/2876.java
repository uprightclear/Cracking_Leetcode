class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] indegree = new int[n];
        int[] res = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> s = new LinkedList<>();
        for(int e : edges) {
            indegree[e]++;
        }
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int x = q.remove();
            s.push(x);
            visited[x] = true;
            if(--indegree[edges.get(x)] == 0) q.add(edges.get(x));
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) fillCycle(edges, visited, res, i);
        }
        while(!s.isEmpty()) {
            int x = s.pop();
            res[x] = res[edges.get(x)] + 1;
        }
        return res;
    }

    public void fillCycle(List<Integer> edges, boolean[] visited, int[] res, int start) {
        int len = 0;
        for(int x = start; !visited[x]; x = edges.get(x)){
            visited[x] = true;
            len++;
        }
        res[start] = len;
        for(int x = edges.get(start); x != start; x = edges.get(x)) {
            res[x] = len;
        }
    }
}