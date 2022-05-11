//https://leetcode.cn/problems/count-sorted-vowel-strings/solution/dong-tai-gui-hua-by-na-xie-ni-hen-mou-xian-de-me-w/
class Solution {
    public int countVowelStrings(int n) {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }
}

//https://leetcode.cn/problems/count-sorted-vowel-strings/solution/dong-tai-gui-hua-xiang-xi-zhu-shi-by-l0o0uis/
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][5];

        //初始化n=1的情况
        for (int i=0;i<5;i++){
            dp[1][i]=1;
        }

        for (int i=2;i<=n;i++){
            //长度i的以u结尾的字符串可以由任意一个长度i-1的字符串结尾加个u得到
            dp[i][4]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3]+dp[i-1][4];
            dp[i][3]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3];
            dp[i][2]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2];
            dp[i][1]=dp[i-1][0]+dp[i-1][1];
            //长度i的以a结尾的字符串只能由长度i-1的以a结尾的字符串结尾加个a得到
            dp[i][0]=dp[i-1][0];
        }

        //最终答案求个和就行啦
        return dp[n][0]+dp[n][1]+dp[n][2]+dp[n][3]+dp[n][4];
    }
}