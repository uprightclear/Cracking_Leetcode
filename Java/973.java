class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]);
            }
        });
        
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            ans[i] = points[i];
        }
        
        return ans;
    }
}