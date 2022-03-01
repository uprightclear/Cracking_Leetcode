class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }
}


class Solution {
    private int popCount(int x) {
        int count;
        for (count = 0; x != 0; ++count) {
            x &= x - 1; // zeroing out the least significant nonzero bit
        }
        return count;
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int x = 0; x <= n; ++x) {
            ans[x] = popCount(x);
        }
        return ans;
    }
}