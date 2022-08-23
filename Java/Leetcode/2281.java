class Solution {
    public int totalStrength(int[] A) {
        int res = 0, ac = 0, mod = (int)1e9 + 7, n = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] acc = new int[n + 2];
        for (int r = 0; r <= n; ++r) {
            int a = r < n ? A[r] : 0;
            ac = (ac + a) % mod;
            acc[r + 1] = (ac + acc[r]) % mod;
            while (!stack.isEmpty() && A[stack.peek()] > a) {
                int i = stack.pop();
                int l = stack.isEmpty() ? -1 : stack.peek();
                long lacc = l < 0 ? acc[i] : acc[i] - acc[l], racc = acc[r] - acc[i];
                int ln = i - l, rn = r - i;
                res = (int)(res + (racc * ln - lacc * rn) % mod * A[i] % mod) % mod;
            }
            stack.push(r);
        }
        return (res + mod) % mod;
    }
}