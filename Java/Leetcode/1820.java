//关于匈牙利算法
//https://blog.csdn.net/dark_scope/article/details/8880547
class Solution {
    public int maximumInvitations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] girlMatched = new int[n];
        for(int i = 0; i < n; i++) girlMatched[i] = -1;
        
        int ans = 0;
        
        for(int i = 0; i < m; i++) {
            Set<Integer> seenGirl = new HashSet<>();
            if(dfs(grid, i, seenGirl, girlMatched)) ans++;
        }
        return ans;
    }
    
    public boolean dfs(int[][] grid, int boy, Set<Integer> seenGirl, int[] girlMatched) {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < n; i++) {
            if(grid[boy][i] == 1 && !seenGirl.contains(i)) {
                seenGirl.add(i);
                if(girlMatched[i] == -1 || dfs(grid, girlMatched[i], seenGirl, girlMatched)) {
                    girlMatched[i] = boy;
                    return true;
                }
            }
        }
        return false;
    }
}