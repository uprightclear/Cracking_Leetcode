class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < len; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] == 0) dp[i] = 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

//binary seach
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        int[] dp = new int[nums.length];
        for(int num : nums) {
            int l = 0, r = len;
            while(l < r) {
                int mid = (l + r) / 2;
                if(dp[mid] < num) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if(r >= len) len++;
            dp[r] = num;
        }
        return len;
    }
}