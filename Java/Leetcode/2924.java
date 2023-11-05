class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] greater = new int[n];
        for(int i = 0; i < n; i++) greater[i] = i;
        for(int[] edge : edges) greater[edge[1]] = edge[0];
        int valid = -1;
        for(int i = 0; i < n; i++) {
            if(greater[i] == i) {
                if(valid == -1) valid = i;
                else return -1;
            }
        }
        return valid;
    }
}