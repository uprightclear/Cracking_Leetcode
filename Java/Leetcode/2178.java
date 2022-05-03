class Solution {
    public List<Long> maximumEvenSplit(long f) {
        LinkedList<Long> ans = new LinkedList<>();
        if (f % 2 == 0) {
            long i = 2;
            while (i <= f) {
                ans.offer(i);
                f -= i;
                i += 2;
            } 
            ans.offer(f + ans.pollLast());
        }
        return ans;
    }
}