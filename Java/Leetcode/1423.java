class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        //store the sum of pre i score
        int[] front = new int[k + 1];
        //store the sum of post i score
        int[] post = new int[k + 1];
        
        for(int i = 0; i < k; i++) {
            front[i + 1] = cardPoints[i] + front[i];
            post[i + 1] = cardPoints[len - 1 - i] + post[i];
        }
        
        int ans = 0;
        for(int i = 0; i <= k; i++) {
            int cur = front[i] + post[k - i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}