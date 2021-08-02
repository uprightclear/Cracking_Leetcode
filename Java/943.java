// Search + Pruning （超出时间限制）
class Solution {
    private int n;
    private int[][] g;
    private String[] a;
    private int best_len;
    private int[] path;
    private int[] best_path;
    
    private void dfs(int d, int used, int cur_len) {
        if (cur_len >= best_len) return;
        if (d == n) {
            best_len = cur_len;
            best_path = path.clone();
            return;
        }
      
        for (int i = 0; i < n; ++i) {
            if ((used & (1 << i)) != 0) continue;
            path[d] = i;
            dfs(d + 1, used | (1 << i), d == 0 ? a[i].length() : cur_len + g[path[d - 1]][i]);
        }
    }
    
    public String shortestSuperstring(String[] A) {
        n = A.length;
        g = new int[n][n];
        a = A;
        //把j放在i后的cost
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < n; ++j) {
                //初始化cost为j的长度
                g[i][j] = A[j].length();
                for (int k = 1; k <= Math.min(A[i].length(), A[j].length()); ++k){
                    if (A[i].substring(A[i].length() - k).equals(A[j].substring(0, k)))
                    g[i][j] = A[j].length() - k;   
                }     
            }
        }
      
        path = new int[n];
        best_len = Integer.MAX_VALUE;
        
        dfs(0, 0, 0);
        
        String ans = A[best_path[0]];
        for (int k = 1; k < n; ++k) {
            int i = best_path[k - 1];
            int j = best_path[k];
            ans += A[j].substring(A[j].length() - g[i][j]);      
        }
        return ans;
    }
}

// DP
class Solution {
    public String shortestSuperstring(String[] words) {  
        int n = words.length;
        int[][] cost = buildGraph(words); // runtime O(N^2 * L^2)
        
        // dp[i][j]: the minimal cost to get to state i with words[j] as the last word
        int[][] dp = new int[1 << n][n];
        int[][] precursor = new int[1 << n][n];
        
        // Runtime: O(N^2 * 2^N )
        for (int state = 1; state < (1 << n); state++) {
            for (int curr = 0; curr < n; curr++) {
                if ((state & (1 << curr)) == 0) continue; // check if it is a valid state ending with words[curr]
                int prevState = state ^ (1 << curr); // find its precursor by removing that bit
                if (prevState == 0) { // if the precursor is empty string
                    dp[state][curr] = words[curr].length();  // the cost would be the string it selft
                    precursor[state][curr] = -1;
                    continue;
                }
                int tempMin = Integer.MAX_VALUE;
                int tempParent = -1;
                for (int prev = 0; prev < n; prev++) {
                    if ((prevState & (1 << prev)) == 0) continue;
                    if (dp[prevState][prev] + cost[prev][curr] < tempMin) {
                        tempMin = dp[prevState][prev] + cost[prev][curr];
                        tempParent = prev;
                    }
                }
                dp[state][curr] = tempMin;
                precursor[state][curr] = tempParent;
            }
        }
        
        int globalMin = Integer.MAX_VALUE;
        int last = -1; // the last word to add in the optimal solution
        for (int i = 0; i < n; i++) {
            if (globalMin > dp[(1 << n) - 1][i]) {
                globalMin = dp[(1 << n) - 1][i];
                last = i;
            }
        }
        
        // reconstruct the answer to return using the dp table
        StringBuilder res = new StringBuilder();
        int state = (1 << n) - 1; // read the dp table backwards starting with the state where all bits are 1
        while ((state ^ (1 << last)) > 0) {
            int prev = precursor[state][last];
            res.insert(0, words[last].substring(words[last].length() - cost[prev][last]));
            state = state ^ (1 << last);
            last = prev;
        }
        res.insert(0, words[last]);
        return res.toString();
    }
    
    private int[][] buildGraph(String[] words) {
        int n = words.length;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                g[i][j] = getCost(words[i], words[j]);
                g[j][i] = getCost(words[j], words[i]);
            }
        }
        return g;
    }
    
    private int getCost(String s1, String s2) {
        int i = 0;
        while (i < s1.length()) {
            if (s1.charAt(i) == s2.charAt(0)) {
                int k = i;
                int p = 0;
                while (k < s1.length()) {
                    if (s1.charAt(k) == s2.charAt(p)) {
                        k++;
                        p++;
                    } else {
                        break;
                    }
                }
                if (k == s1.length()) return s2.length() - p; 
            }
            i++;
        }
        return s2.length();
    }
}