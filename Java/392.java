class Solution {
    public boolean isSubsequence(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        if(lens > lent) return false;
        int pre = 0;
        int ans = 0;
        for(int i = 0; i < lens; i++) {
            char cur = s.charAt(i);
            for(int j = pre; j < lent; j++) {
                if(t.charAt(j) == cur) {
                    ans++;
                    pre = j + 1;
                    break;
                }
                if(j == lent - 1) return false;
            }
        }
        return ans == lens;
    }
}