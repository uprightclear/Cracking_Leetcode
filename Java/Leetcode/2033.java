class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> arr = new ArrayList<>();
        int m = grid.length,n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr.add(grid[i][j]);
            }
        }
        Collections.sort(arr);
        int median = arr.get((arr.size())/2);
        int count = 0;
        for(int val : arr){
            int diff = Math.abs(val-median);
            if(diff % x!=0) return -1;
            count += diff / x;   
        }
        return count;
    }
}