class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustOther = new int[n + 1];
        int[] beTrusted = new int[n + 1];
        for(int[] pair : trust) {
            trustOther[pair[0]]++;
            beTrusted[pair[1]]++;
        }
        for(int i = 1; i <= n; i++) {
            if(trustOther[i] == 0 && beTrusted[i] == n - 1) return i; 
        }
        return -1;
    }
}