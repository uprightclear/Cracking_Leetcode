class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, pre = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > pre) ans++;
            pre = nums[i];
        }
        return ans;
    }
}