class Solution {
    // let's try the typical solution: up-bottom dfs with dp
    public String encode(String s) {
        int len = s.length();
        String[][] dp = new String[len][len];
        return helper(s, 0, s.length() - 1, dp);
    }
    
    private String helper(String s, int l, int r, String[][] dp) {
        // return the result of s[l...r] (both inclusive)
        if (l > r) return "";
        
        if (dp[l][r] != null) return dp[l][r];
        String str = s.substring(l, r + 1);
        if (r - l + 1 < 5) {
            // length is smaller then 5, encoding will not help
            dp[l][r] = str;
        } else {
            dp[l][r] = str;
            for (int k = l; k < r; k++) {
                String left = helper(s, l, k, dp), right = helper(s, k + 1, r, dp);      
                if (left.length() + right.length() < dp[l][r].length()) {
                    dp[l][r] = left + right;
                }
            }
            for (int k = 0; k < str.length(); k++) {
                // find pattern in itself
                String pattern = str.substring(0, k+1);
                if (str.length() % pattern.length() == 0
                   && str.replace(pattern, "").length() == 0) {
                    int num = str.length() / pattern.length();
                    String newStr = num + "[" + helper(s, l, l + k, dp) + "]";
                    if (newStr.length() < dp[l][r].length()) {
                        dp[l][r] = newStr;
                    }
                }
            }
        }
        return dp[l][r];
    }
}