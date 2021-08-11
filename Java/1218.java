//超时
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int res = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++){
            for(int j = i - 1; j >= 0; j--){
                if(arr[i] - arr[j] == difference){
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}


class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> dp = new HashMap<>();
        for(int i : arr){
            int tmp = dp.getOrDefault(i - difference, 0) + 1;
            dp.put(i, tmp);
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}