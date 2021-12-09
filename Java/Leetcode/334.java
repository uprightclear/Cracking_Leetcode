//time out
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] > 1) return true;
                }
            }
        }
        return false;
    }
}


//greedy
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if(len < 3) return false;
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= small){
                small = num;
            }else if(num <= mid){
                mid = num;
            }else return true;
        }
        return false;
    }
}