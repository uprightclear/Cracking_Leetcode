class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int cur = nums[i];
            while(!stack.isEmpty() && cur > nums[stack.peek()]) {
                ans[stack.pop()] = cur;
            }
            stack.push(i);
        }
        for(int i = 0; i < n; i++) {
            if(stack.isEmpty()) break;
            int cur = nums[i];
            while(!stack.isEmpty() && cur > nums[stack.peek()]) {
                ans[stack.pop()] = cur;
            }
        }
        
        return ans;
    }
}