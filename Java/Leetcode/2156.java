class Solution {
    public String subStrHash(String s, int p, int m, int k, int hashValue) {
        long cur = 0, pk = 1;
        int res = 0, n = s.length();
        for (int i = n - 1; i >= 0; --i) {
            cur = (cur * p + s.charAt(i) - 'a' + 1) % m;
            if (i + k >= n) pk = pk * p % m;
            else cur = (cur - (s.charAt(i + k) - 'a' + 1) * pk % m + m) % m;
            
            if (cur == hashValue) res = i;
        }
        return s.substring(res, res + k);
    }
}