class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph.computeIfAbsent(from, k -> new LinkedList<>()).add(to);
        }
        return search(graph, new HashSet<>(), source, destination); 
    }
    
    private boolean search(Map<Integer, List<Integer>> graph, Set<Integer> visited, int source, int destination) {
        if (!graph.containsKey(source)) { return source == destination; }
        visited.add(source);
        for (int next : graph.get(source)) {
            if (visited.contains(next) || !search(graph, visited, next, destination)) return false;
        }
        visited.remove(source);
        return true; 
    }
}