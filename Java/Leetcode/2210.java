//remove the duplicate and then count
class Solution {
    public int countHillValley(int[] nums) {
        int len = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[len - 1]) {
                nums[len] = nums[i];
                len++;
            }
        }
        
        int ans = 0;
        for(int i = 1; i < len - 1; i++) {
            if(nums[i - 1] < nums[i] == nums[i + 1] < nums[i]) ans++;
        }
        return ans;
    }
}