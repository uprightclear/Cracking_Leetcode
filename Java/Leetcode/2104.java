class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        for(int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int max = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }
}