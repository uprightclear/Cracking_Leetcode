class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int window_sum = 0;     
        for(int i = 0; i < k; i++) {
            window_sum += nums[i];
        }
        int max = window_sum;
        for(int i = k; i < nums.length; i++){
            window_sum -= nums[i - k];
            window_sum += nums[i];
            if(max < window_sum) {
                max = window_sum;
            }
        }
        return max / (k * 1.0d);
    }
}