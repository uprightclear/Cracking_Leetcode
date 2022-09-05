class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int pile : piles) pq.offer(pile);
        while(k-- > 0) {
            int cur = pq.poll();
            pq.offer(cur - cur / 2);
        }
        int ans = 0;
        while(!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}