class Solution {
    public boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!enough(mi, m, n, k)) lo = mi + 1;
            else hi = mi;
        }
        return lo;
    }
}


class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while(l < r){
            int mid = l + r >> 1;
            if(chk(mid, m, n, k)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    public boolean chk(int mid, int m, int n, int k){
        int cnt = 0;
        for(int i = 1; i <= m; i++){
            cnt += Math.min(mid / i,n);
        }
        return cnt >= k;
    }
}