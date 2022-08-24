class SORTracker {
    private TreeSet<Location> locations = new TreeSet<>(); 
    private Location lastReturned = new Location("", Integer.MAX_VALUE); // Last returned (or equivalent)
    
    public void add(String name, int score) {
        Location location = new Location(name, score);
        locations.add(location);
        
		// If the new location is before the last returned, we need to update the pointer
        if (location.compareTo(lastReturned) < 0) {
            lastReturned = locations.lower(lastReturned);
        }
    }
    
    public String get() {
        // Update the pointer
        lastReturned = locations.higher(lastReturned);
        
        return lastReturned.name;
    }
    
    class Location implements Comparable<Location> {
        private final String name;
        private final int score;
        
        public Location(String name, int score) {
            this.name = name;
            this.score = score;
        }
        
        public int compareTo(Location l) {
            // Sort by score (desc), then name (asc)
            return score != l.score ? -Integer.compare(score, l.score) : name.compareTo(l.name);
        }
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */


class SORTracker {
    class Node{
        String name;
        int score;
        
        public Node(String n, int s){
            this.name = n;
            this.score = s;
        }
    }
    PriorityQueue<Node> max;
    PriorityQueue<Node> min;
    
    public SORTracker() {
        min = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.score == o2.score ? o2.name.compareTo(o1.name) : o1.score - o2.score;
            }
        });
        
        max = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.score == o2.score ? o1.name.compareTo(o2.name) : o2.score - o1.score;
            }
        });
    }

    public void add(String name, int score) {
        min.add(new Node(name, score));
        Node lameOne = min.poll();
        max.add(lameOne);
    }

    public String get() {
        Node bestOne = max.poll();
        min.add(bestOne);
        return min.peek().name;
    }
}
