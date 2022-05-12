class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = -1, i = 0, j = nums.length - 1;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum < k) {
                ans = Math.max(ans, sum);
                i++;
            }
            else j--;
        }
        return ans;
    }
}