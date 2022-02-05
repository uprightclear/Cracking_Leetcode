class Solution {
    public int sumOfUnique(int[] nums) {
        if(nums.length == 1) return nums[0];
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) ans += nums[i];
        }
        if(nums[0] != nums[1]) ans += nums[0];
        if(nums[nums.length - 1] != nums[nums.length - 2]) ans += nums[nums.length - 1];
        return ans;
    }
}