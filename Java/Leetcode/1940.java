class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int[] cnt = new int[101];
        for(int[] arr : arrays) {
            for(int e : arr) {
                cnt[e]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            if(cnt[i] == arrays.length) ans.add(i);
        }
        return ans;
    }
}