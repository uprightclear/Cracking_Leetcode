class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int l = 0;
        for(int r = 0; r < nums.length; r++) {
            if(nums[r] - nums[l] > k) {
                ans++;
                l = r;
            }
        }
        return ans;
    }
}