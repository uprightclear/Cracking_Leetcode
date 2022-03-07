class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] set = new int[n];
        Arrays.fill(set, -1);
        
        for(int[] edge : edges) {
            int parentX = find(set, edge[0]);
            int parentY = find(set, edge[1]);
                
            if(parentX == parentY) return false;
            
            set[parentX] = parentY;
        }
        
        return n == edges.length + 1;
    }
    
    private int find(int[] set, int i) {
        if(set[i] == -1) return i;
        return find(set, set[i]);
    }
}