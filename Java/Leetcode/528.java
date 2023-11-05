class Solution {
    int[] pre;
    int total;
    public Solution(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for(int i = 1; i < w.length; i++) {
            pre[i] = pre[i - 1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }
    
    public int pickIndex() {
        int x = (int) (Math.random() * total) + 1;
        return bs(x);
    }

    private int bs(int x) {
        int l = 0, r = pre.length;
        while(l < r) {
            int mid = (l + r) / 2;
            if(pre[mid] >= x) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */