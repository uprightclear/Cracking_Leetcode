class Solution {
    List<Integer> list = new ArrayList<>();
    int n, k;
    public int[] numsSameConsecDiff(int n, int k) {
        this.n = n;
        this.k = k;
        for(int i = 1; i <= 9; i++) {
            dfs(i, 1);
        }
        //return list.toArray(new int[list.size()]);
        return list.stream().mapToInt(i->i).toArray();
    }
    
    public void dfs(int cur, int len) {
        if(len == n) {
            list.add(cur);
            return;
        }
        int tail = cur % 10;
        if(k == 0) dfs(cur * 10 + tail, len + 1);
        else {
            for(int i = -k; i <= k; i += k + k) {
                if(tail + i >= 0 && tail + i <= 9) {
                    dfs(cur * 10 + tail + i, len + 1);
                }
            }
        }        
    }
}