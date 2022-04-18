class Solution {
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] ans = new int[len];
        for(int i = 0, idx = -len; i < len; i++) {
            if(s.charAt(i) == c) idx = i;
            ans[i] = i - idx;
        }
        for(int i = len - 1, idx = 2 * len; i >= 0; i--) {
            if(s.charAt(i) == c) idx = i;
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }
}