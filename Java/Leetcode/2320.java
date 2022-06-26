class Solution {
    public int countHousePlacements(int n) {
        int a = 1, b = 1, c = 2, mod = (int)1e9 + 7;
        for (int i = 0; i < n; i++) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return (int)(1L * c * c % mod);
    }
}


class Solution {
    public int countHousePlacements(int n) {
        long[] put = new long[n+1], notPut = new long[n+1];
        put[1] = 1;
        notPut[1] = 1;
        for (int i = 2; i <= n; i++) {
            put[i] = notPut[i-1]%1000000007;
            notPut[i] = (notPut[i-1] + put[i-1])%1000000007;
        }
        return (int)((put[n]+notPut[n])*(put[n]+notPut[n])%1000000007);
    }
}


// 1 -> 4 (2*2)
// 2 -> 9 (3*3)
// 3 -> 25 (5*5)
// 4 -> 64 (8*8)