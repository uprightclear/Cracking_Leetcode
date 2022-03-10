class Solution {
    long maxScore = 0;
    int cnt = 0, n;
    List<Integer>[] children;
    
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            children[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < n; i++) {
            int p = parents[i];
            if (p != -1) {
                children[p].add(i);
            }
        }
        dfs(0);
        return cnt;
    }
    
    //calculate the number of nodes whose root is node
    public int dfs(int node) {
        long score = 1;
        int size = n - 1;
        for(int c : children[node]) {
            //child's node 
            int t = dfs(c);
            score *= t;
            size -= t;
        }
        if(node != 0) score *= size;
        if(score == maxScore) cnt++;
        else if(score > maxScore) {
            maxScore = score;
            cnt = 1;
        }
        return n - size;
    }
}