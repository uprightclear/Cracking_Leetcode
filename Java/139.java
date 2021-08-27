class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet(wordDict);
        int maxLen = 0;
        for(String word : wordDict) maxLen = Math.max(maxLen, word.length());
        boolean[] dp = new boolean[s.length() + 1]; //dp[i]: the word end with s[i - 1] can be divided or not
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = i - 1; j >= 0 && j >= i - maxLen; j--){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}