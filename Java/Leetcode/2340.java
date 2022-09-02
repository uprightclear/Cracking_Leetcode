class Solution {
    public int minimumSwaps(int[] nums) {
        int min = Integer.MAX_VALUE, minIdx = 0;
        int max = Integer.MIN_VALUE, maxIdx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
            if(nums[i] >= max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        return minIdx > maxIdx ? minIdx + nums.length - maxIdx - 2 : minIdx + nums.length - maxIdx - 1;
    }
}