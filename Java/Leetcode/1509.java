class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4) return 0;
        
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < 4; i++) {
            //we change only the first or the last
            //eg. if we select the first than we should compare it with the fourth to the last
            //since we assume we have change the last 3 to the same as the fourth to the last
            ans = Math.min(ans, nums[n - 4 + i] - nums[i]);
        }
        
        return ans;
    }
}