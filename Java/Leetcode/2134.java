class Solution {
    public int minSwaps(int[] nums) {
        int len = nums.length;
        int totalOnes = 0;
        int curOnesInWindow = 0;
        int maxOnesInWindow = 0;
        for(int num : nums) {
            totalOnes += num;
        }
        
        for(int i = 0, j = 0; i < len; i++) {
            while(j - i < totalOnes) curOnesInWindow += nums[j++ % len];
            maxOnesInWindow = Math.max(maxOnesInWindow, curOnesInWindow);
            curOnesInWindow -= nums[i];
        }
        
        return totalOnes - maxOnesInWindow;
    }
}