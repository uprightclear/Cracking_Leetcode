class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length, res[] = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i])
                res[stack.pop()]++;
            if (!stack.isEmpty())
                res[stack.peek()]++;
            stack.push(i);
        }
        return res;
    }
}