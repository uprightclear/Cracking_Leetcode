class Solution {
    public long maxScore(int[][] edges) {
        // Step 1: Initialize necessary variables
        int n = edges.length;
        List<int[]>[] graph = new ArrayList[n]; // Step 1 continued: Create an array of lists to represent the graph
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>(); // Step 1 continued: Initialize each list in the graph array
        
        int root = 0;
        for (int i = 0; i < n; i++)
            if (edges[i][0] != -1)
                graph[edges[i][0]].add(new int[]{i, edges[i][1]}); // Step 2: Build the graph
        
        long[] result = dfs(graph, root); // Step 3: Perform DFS starting from the root node
        return Math.max(result[0], result[1]); // Step 4: Return the maximum score obtained from the root node
    }
    
    // Step 5: DFS method to traverse the tree and find maximum scores
    // For node and its children [child_0, child_1, child_2, ...]
    // result[0]: max score if we do not pick any edge from node to child_i
    // result[1]: max score if we pick one edge from node to child_i
    private long[] dfs(List<int[]>[] graph, int node) {
        long[] result = new long[2]; // Initialize the result array to store maximum scores
        
        for (int[] nei : graph[node]) { // Step 6: Iterate through each neighbor (child) of the current node
            long[] neiResult = dfs(graph, nei[0]); // Step 7: Recursively call DFS on the neighbor
            
            long tmp = Math.max(neiResult[0], neiResult[1]); // Step 8: Calculate the maximum score if no edge is picked
            
            // Step 9: Update result[0] to account for maximum score without picking the current neighbor's edge
            result[0] += tmp;
            
            // Step 10: Update result[1] to consider the maximum score if one edge is picked
            // This ensures that the chosen edge is non-adjacent to the previously chosen edges
            result[1] = Math.max(result[1], nei[1] + neiResult[0] - tmp);
        }
        
        // Step 11: Update result[1] by adding result[0] to account for the case where we pick an edge from the current node
        result[1] += result[0];
        
        // Step 12: Return the result array containing maximum scores for the current node
        return result;
    }
}
