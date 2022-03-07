//Union Find
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] set = new int[n];
        Arrays.fill(set, -1);
        
        for(int[] edge : edges) {
            int parentX = find(set, edge[0]);
            int parentY = find(set, edge[1]);
                
            if(parentX == parentY) return false;
            
            set[parentX] = parentY;
        }
        
        return n == edges.length + 1;
    }
    
    private int find(int[] set, int i) {
        if(set[i] == -1) return i;
        return find(set, set[i]);
    }
}

//DFS
class Solution {
    
    private Map<Integer, Set<Integer>> adjList = new HashMap<>();
    private Set<Integer> seen = new HashSet<>();
    
    
    public boolean validTree(int n, int[][] edges) {
        
        if (edges.length != n - 1) return false;
        
        for (int i = 0; i < n; i++) {
            adjList.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        // We return true iff no cycles were detected,
        // AND the entire graph has been reached.
        return dfs(0, -1) && seen.size() == n;   
    }
    
    public boolean dfs(int node, int parent) {
        if (seen.contains(node)) return false;
        seen.add(node);
        for (int neighbour : adjList.get(node)) {
            if (parent != neighbour) {
                boolean result = dfs(neighbour, node);
                if(!result) return false;
            }
        }
        return true;
    }
}