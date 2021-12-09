class Solution {
    public int[] findBuildings(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        for(int i = len - 1; i >= 0; i--) {
            if(i == len - 1 || heights[i] > heights[stack.peek()]) stack.push(i);
        }
        
        int size = stack.size();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++) {
            ans[i] = stack.pop();
        }
        
        return ans;
    }
}