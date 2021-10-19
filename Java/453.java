//Math 每次操作既可以理解为使 n-1n−1 个元素增加 11，也可以理解使 11 个元素减少 11
class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = nums.length - 1; i > 0; i--) {
            ans += nums[i] - nums[0];
        }
        return ans;
    }
}