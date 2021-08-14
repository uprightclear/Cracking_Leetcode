class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        //order[i][j]：j对于i的亲密程度
        int[][] order = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++){
                order[i][preferences[i][j]] = j; 
            }
        }

        int[] match = new int[n];
        for(int[] pair : pairs){
            match[pair[0]] = pair[1];
            match[pair[1]] = pair[0];
        }

        int res = 0;
        for(int x = 0; x < n; x++){
            int y = match[x];
            int index = order[x][y];
            for(int i = 0; i < index; i++){
                int u = preferences[x][i];
                int v = match[u];
                if(order[u][v] > order[u][x]){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}