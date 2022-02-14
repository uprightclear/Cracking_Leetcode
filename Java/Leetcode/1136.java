class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int ans = 0;
        int[] indegree = new int[n + 1];
        boolean[] used = new boolean[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] relation : relations) {
            indegree[relation[1]]++;
            List<Integer> list = map.getOrDefault(relation[0], new ArrayList<Integer>());
            list.add(relation[1]);
            map.put(relation[0], list);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        if(q.isEmpty()) return -1;
        while(!q.isEmpty()) {
            ans++;
            int size = q.size();
            while(size-- > 0) {
                int cur = q.poll();
                used[cur] = true;
                for(int m : map.getOrDefault(cur, new ArrayList<Integer>())) {
                    if(!used[m] && --indegree[m] == 0) {
                        q.offer(m);
                        used[m] = true;
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            if(used[i] == false) return -1;
        }
        return ans;
    }
}