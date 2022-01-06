class Solution {
    public int maxDepth(String s) {
        int par = 0;
        int ans = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
               par++;
               ans = Math.max(ans, par);
            }else if(c == ')') par--;
        }
        return ans;
    }
}