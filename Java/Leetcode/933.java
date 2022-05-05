class RecentCounter {
    List<Integer> list;
    public RecentCounter() {
        list = new ArrayList<>();
    }
    
    public int ping(int t) {
        list.add(t);
        int l = 0, r = list.size();
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(list.get(mid) >= t - 3000) r = mid;
            else l = mid + 1;
        }
        return list.size() - l;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<Integer>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}