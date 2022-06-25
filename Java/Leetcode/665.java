class Solution {
    public boolean checkPossibility(int[] nums) {
        int tmp = helper(nums);
        return nums.length - tmp <= 1;
    }
    
    public int helper(int[] nums) {
        int len = 0, n = nums.length;
        int[] dp = new int[n];
        for(int num : nums) {
            int l = 0, r = len;
            while(l < r) {
                int mid = (l + r) / 2;
                if(dp[mid] <= num) l = mid + 1;
                else r = mid;
            }
            if(l >= len) len++;
            dp[l] = num;
        }    
        return len;
    }
}