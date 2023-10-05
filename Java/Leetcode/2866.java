class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] left = new long[n];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        long res = 0, cur = 0;
        for(int i = 0; i < n; i++) {
            while(stack.size() > 1 && maxHeights.get(stack.peek()) > maxHeights.get(i)) {
                int j = stack.pop();
                cur -= 1L * (j - stack.peek()) * maxHeights.get(j);
            }
            cur += 1L * (i - stack.peek()) * maxHeights.get(i);
            stack.push(i);
            left[i] = cur;
        }

        stack.clear();
        stack.push(n);
        cur = 0;
        for(int i = n - 1; i >= 0; i--) {
            while(stack.size() > 1 && maxHeights.get(stack.peek()) > maxHeights.get(i)) {
                int j = stack.pop();
                cur -= 1L * -(j - stack.peek()) * maxHeights.get(j);
            }
            cur += 1L * -(i - stack.peek()) * maxHeights.get(i);
            stack.push(i);
            res = Math.max(res, left[i] + cur - maxHeights.get(i));
        }
        
        return res;
    }
}