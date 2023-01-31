class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        if(scores.length == 1)
            return scores[0];
            
        int[][] arr = new int[scores.length][2];
        for(int i = 0; i < scores.length; i++){
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        int[] dp = new int[scores.length];
        for(int i = 0; i < scores.length; i++){
            dp[i] = arr[i][1];
            System.out.println(dp[i]);
        }

        int ans = dp[0];
        for(int i = 0; i < scores.length; i++) {
            for(int j = 0; j < i; j++) { // 找在i之前有没有比i小的
                if(arr[j][1] <= arr[i][1]) {
                    dp[i] = Math.max(dp[j]+arr[i][1], dp[i]);
                }
                ans = Math.max(ans,dp[i]);
            }
        }

        return ans;
    }
}