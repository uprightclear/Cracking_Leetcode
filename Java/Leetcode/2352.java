class Solution {
    public int equalPairs(int[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                boolean eq = true;
                for(int k = 0; k < grid.length; k++) {
                    if(grid[i][k] != grid[k][j]) {
                        eq = false;
                        break;
                    }
                }
                if(eq) ans++;
            }
        }
        return ans;
    }
}

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length, ans = 0;
        Map<String,Integer> cnt = new HashMap<>();
        for(int i = 0; i < n; i++){
            String t1 = "";
            for(int j = 0; j < n; j++) t1 += "$" + grid[i][j];
            cnt.put(t1, cnt.getOrDefault(t1, 0) + 1);
        }
        for(int i = 0;i < n; i++){
            String t2 = "";
            for(int j = 0; j < n; j++) t2 += "$" + grid[j][i];
            ans += cnt.getOrDefault(t2, 0);
        }
        return ans;
    }
}