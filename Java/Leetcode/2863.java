class Solution {
    public int maxSubarrayLength(int[] nums) {
        int n = nums.length;
        Deque<int[]> stack = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            if(stack.isEmpty() || stack.peek()[0] < nums[i]) stack.push(new int[] {nums[i], i});
        }
      
        int res = 0;
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek()[1] >= i) stack.pop();
            int lastIndex = 0;
            while(!stack.isEmpty() && stack.peek()[0] > nums[i]) {
                lastIndex = stack.pop()[1];
                res = Math.max(res, i - lastIndex + 1); 
            }
            
        }
        return res;
    }
}