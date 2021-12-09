class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int t = 1; t <= k + 1; ++t) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
            }
        }
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, f[t][dst]);
        }
        return ans == INF ? -1 : ans;
    }
}

//优化
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[] f = new int[n];
        Arrays.fill(f, INF);
        f[src] = 0;
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            int[] g = new int[n];
            Arrays.fill(g, INF);
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                g[i] = Math.min(g[i], f[j] + cost);
            }
            f = g;
            ans = Math.min(ans, f[dst]);
        }
        return ans == INF ? -1 : ans;
    }
}


class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
     
        // Build the adjacency matrix
        int adjMatrix[][] = new int[n][n];
        for (int[] flight: flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }
        
        // Shortest distances dictionary
        HashMap<Pair<Integer, Integer>, Long> distances = new HashMap<Pair<Integer, Integer>, Long>();
        distances.put(new Pair<Integer, Integer>(src, 0), 0L);
        
        // Number of stops done
        int stops = 0;
        
        // Final answer
        long ans = Long.MAX_VALUE;
        
        // BFS Queue
        LinkedList<Integer> bfsQueue = new LinkedList<Integer>();
        bfsQueue.add(src);
        
        // Iterate until we exhaust K+1 levels or the queue gets empty
        while (!bfsQueue.isEmpty() && stops < K + 1) {
            
            // Iterate on current level
            int length = bfsQueue.size();
            for (int i = 0; i < length; ++i) {
                
                // Loop over neighbors of popped node
                int node = bfsQueue.poll();
                for (int nei = 0; nei < n; ++nei) {
                          
                    if (adjMatrix[node][nei] > 0) {
                        
                        long dU = distances.getOrDefault(new Pair<Integer, Integer>(node, stops), Long.MAX_VALUE);
                        long dV = distances.getOrDefault(new Pair<Integer, Integer>(nei, stops + 1), Long.MAX_VALUE);
                        long wUV = adjMatrix[node][nei];

                        // No need to update the minimum cost if we have already exhausted our K stops. 
                        if (stops == K && nei != dst) {
                            continue;
                        }

                        if (dU + wUV < dV) {
                            distances.put(new Pair<Integer, Integer>(nei, stops + 1), dU + wUV);
                            bfsQueue.add(nei);
                            
                            // If the neighbor is infact the destination, update the answer accordingly
                            if (nei == dst) {
                                ans = Math.min(ans, dU + wUV);
                            }
                        }    
                    }
                }
            }
            
            stops++;
        }
        
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}