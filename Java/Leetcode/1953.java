//TLE
class Solution {
    public long numberOfWeeks(int[] milestones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int mile : milestones) pq.offer(mile);
        long ans = 0;
        int tmp = 0;
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            if(tmp != 0) pq.offer(tmp);
            ans++;
            tmp = cur - 1;
        }
        return ans;
    }
}


class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        int max = 0;
        for(int mile : milestones) {
            sum += mile;
            max = Math.max(max, mile);
        }
        if(max <= sum / 2) return sum;
        return 2 * (sum - max) + 1;
    }
}