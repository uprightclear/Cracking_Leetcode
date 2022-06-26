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


// 1 -> 4 (2*2)
// 2 -> 9 (3*3)
// 3 -> 25 (5*5)
// 4 -> 64 (8*8)