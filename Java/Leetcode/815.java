class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        Map<Integer, Set<Integer>> toRoutes = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int j : routes[i]) {
                if(!toRoutes.containsKey(j)) {
                    toRoutes.put(j, new HashSet<Integer>());
                }
                toRoutes.get(j).add(i);
            }
        }

        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[] {source, 0});
        Set<Integer> seenStops = new HashSet<>();
        seenStops.add(source);
        boolean[] seenRoutes = new boolean[n];
        while(!bfs.isEmpty()) {
            int stop = bfs.peek()[0], count = bfs.peek()[1];
            bfs.poll();
            if(stop == target) return count;
            for(int i : toRoutes.get(stop)) {
                if(seenRoutes[i]) continue;
                for(int j : routes[i]) {
                    if(!seenStops.contains(j)) {
                        seenStops.add(j);
                        bfs.offer(new int[] {j, count + 1});
                    }
                }
                seenRoutes[i] = true;
            }
        }
        return -1;
    }
}