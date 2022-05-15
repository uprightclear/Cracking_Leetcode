class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }
}


public class Solution {
    private int popCount(int x) {
        int count = 0;
        while(x != 0) {
            x &= x - 1;
            count++;
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