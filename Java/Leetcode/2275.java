class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0;
        for(int i = 0; i <= 31; i++) {
            int n = 0;
            for(int cand : candidates) {
                if(((cand >> i) & 1) > 0) n++;
            }
            ans = Math.max(ans, n);
        }
        return ans;
    }
}