class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4) return 0;
        
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < 4; i++) {
            ans = Math.min(ans, nums[n - 4 + i] - nums[i]);
        }
        
        return ans;
    }
}