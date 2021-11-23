class Solution {
    public int minSwaps(int[] data) {
        int len = data.length;
        int l = 0, r = 0;
        int totalOnes = 0;
        int curOnesInWindow = 0;
        int maxOnesInWindow = 0;
        for(int num : data) {
            totalOnes += num;
        }
        
        while(r < len) {
            curOnesInWindow += data[r++];
            if(r - l > totalOnes) {
                curOnesInWindow -= data[l++];
            }
            maxOnesInWindow = Math.max(maxOnesInWindow, curOnesInWindow);
        }
        
        return totalOnes - maxOnesInWindow;
    }
}