class Solution {
    public int minimumOperations(int[] nums) {
        int l = 0, r = nums.length - 1, ans = 0;
        while(l < r) {
            if(nums[l] == nums[r]) {
                l++;
                r--;
            } else if(nums[l] < nums[r]) {
                nums[l + 1] += nums[l];
                l++;
                ans++;
            } else {
                nums[r - 1] += nums[r];
                r--;
                ans++;
            }
        }
        return ans;
    }
}