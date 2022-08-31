class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                ans[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int index = stack.pop();
            ans[index] = prices[index];
        }
        return ans;
    }
}