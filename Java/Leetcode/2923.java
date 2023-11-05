class Solution {
    public int findChampion(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            boolean valid = true;
            for(int j = 0; j < grid.length; j++) {
                if(grid[j][i] == 1) {
                    valid = false;
                    break;
                }
            }
            if(valid) return i;
        }
        return 0;
    }
}