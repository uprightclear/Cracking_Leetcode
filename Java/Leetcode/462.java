class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ret = 0, x = nums[n / 2];
        for (int i = 0; i < n; i++) {
            ret += Math.abs(nums[i] - x);
        }
        return ret;
    }
}