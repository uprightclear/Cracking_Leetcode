class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int[] preNumOf1 = new int[len + 1];
        for(int i = 1; i <= len; i++) {
            preNumOf1[i] = preNumOf1[i - 1] + (s.charAt(i - 1) == '1' ? 1 : 0);
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= len; i++) {
            ans = Math.min(ans, preNumOf1[i] + (len - i - (preNumOf1[len] - preNumOf1[i])));
        }
        return ans;
    }
}