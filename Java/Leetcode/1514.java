class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Adjacency list
        List<List<Pair<Integer, Double>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Pair<>(v, p));
            adj.get(v).add(new Pair<>(u, p));
        }

        // Distances array
        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);
        dist[start] = 1.0;

        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Pair<Integer, Double> pair : adj.get(curr)) {
                int next = pair.getKey();
                double prob = pair.getValue();
                double newProb = dist[curr] * prob;

                if (newProb > dist[next]) {
                    dist[next] = newProb;
                    queue.offer(next);
                }
            }
        }

        return dist[end];
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}