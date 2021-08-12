class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] f = new int[len][len];
        for(int i = len - 1; i >= 0; i--){
            f[i][i] = 1;
            for(int j = i + 1; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    f[i][j] = f[i + 1][j - 1] + 2;
                }else{
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][len - 1];
    }
}