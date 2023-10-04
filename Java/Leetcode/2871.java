class Solution {
    public int maxSubarrays(int[] nums) {
        int val = -1, ans = 0;
        for(int num : nums) {
            val &= num;
            if(val == 0) {
                ans++;
                val = -1;
            }
        }
        return ans == 0 ? 1 : ans;
    }
}