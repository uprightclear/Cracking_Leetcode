class Leaderboard {

    private Map<Integer, Integer> scores;
    
    public Leaderboard() {
        this.scores = new HashMap<Integer, Integer>();
    }
    
    public void addScore(int playerId, int score) {
        
        if (!this.scores.containsKey(playerId)) {
            this.scores.put(playerId, 0);
        }
        
        this.scores.put(playerId, this.scores.get(playerId) + score);
    }
    
    public int top(int K) {
        
        // A min-heap in java containing entries of a hash map. Note that we have to provide
        // a comparator of our own to make sure we get the ordering right of these objects.
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        for (Map.Entry<Integer, Integer> entry : this.scores.entrySet()) {
            heap.offer(entry);
            if (heap.size() > K) {
                heap.poll();
            }
        }
        
        int total = 0;
        Iterator value = heap.iterator();
        while (value.hasNext()) { 
            total += ((Map.Entry<Integer, Integer>)value.next()).getValue();   
        }
        
        return total;
    }
    
    public void reset(int playerId) {
        this.scores.put(playerId, 0);
    }
}