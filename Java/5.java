class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();

        if(len < 2) return s;

        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }

        int begin = 0, maxlen = 1;

        for(int j = 1; j < len; j++){//end
            for(int i = 0; i < j; i++){//start
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    if(j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                }

                if(dp[i][j] && j - i + 1 > maxlen){
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }
}