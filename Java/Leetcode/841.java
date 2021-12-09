class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        queue.offer(0);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int cur = queue.poll();
                for(int next : rooms.get(cur)) {
                    if(set.add(next)) queue.offer(next);
                    if(set.size() == n) return true;
                }
            }
        }
        return false;
    }
}