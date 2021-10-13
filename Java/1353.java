//Time Limit Exceeded
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int ans = 0;
        boolean[] seen = new boolean[100001];
        for(int[] event : events) {
            for(int i = event[0]; i <= event[1]; i++) {
                if(seen[i]) continue;
                seen[i] = true;;
                ans++;
                break;
            }
        }
        return ans;
    }
}


class Solution {
    public int maxEvents(int[][] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, n = A.length;
        for (int d = 1; d <= 100000; ++d) {
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();
            while (i < n && A[i][0] == d)
                pq.offer(A[i++][1]);
            if (!pq.isEmpty()) {
                pq.poll();
                ++res;
            }
            if (pq.isEmpty() && i >= n){
                break;
            }
        }
        return res;
    }
}