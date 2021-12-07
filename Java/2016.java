class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int res = -1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > min) {
                res = Math.max(res, nums[i] - min);
            } else {
                min = nums[i];
            }
        }
        return res;
    }
}