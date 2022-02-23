class Solution {
    public int minimumLines(int[][] points) {
        int n = points.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        
        for(int state = 1; state < (1 << n); state++) {
            if(Integer.bitCount(state) <= 2 || formLine(points, state)) dp[state] = 1;
        }
        
        for(int state = 1; state < (1 << n); state++) {
            //remove one point every time
            for(int subset = state; subset > 0; subset = (subset - 1) & state) {
                dp[state] = Math.min(dp[state], dp[subset] + dp[state - subset]);
            }
        }
        return dp[(1 << n) - 1];
    }
    
    private boolean formLine(int[][] points, int state) {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < points.length; i++) {
            //add all the points in the current state to temp
            if(state % 2 == 1) temp.add(i);
            state /= 2;
        }
        //check whether can the points in current state can be in a line
        for (int i = 1; i < temp.size(); i++) {
            int a = temp.get(0);
            int b = temp.get(1);
            int c = temp.get(i);
            if ((points[c][1] - points[a][1]) * (points[b][0] - points[a][0]) != (points[b][1] - points[a][1]) * (points[c][0] - points[a][0]))
                return false;
        }
        return true; 
    }
}