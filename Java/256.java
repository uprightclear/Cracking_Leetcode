class Solution {
    public int minCost(int[][] costs) {
        int row = costs.length;
        int col = costs[0].length;
        
        for(int i = row - 2; i >= 0; i--) {
            for(int j = 0; j < col; j++) {
                int tmp = Integer.MAX_VALUE;
                for(int index = 0; index < col; index++){
                    if(j != index) tmp = Math.min(tmp, costs[i + 1][index]);
                }
                costs[i][j] += tmp;
            }
        }
        
        int ans = costs[0][0];
        for(int i = 1; i < col; i++) {
            ans = Math.min(ans, costs[0][i]);
        }
        return ans;
    }
}