class Solution {
    public int numSplits(String str) {
        int l[] = new int[26], r[] = new int[26], d_l = 0, d_r = 0, res = 0;
        char[] s = str.toCharArray();
        for (char ch : s) d_r += ++r[ch - 'a'] == 1 ? 1 : 0;
        for (int i = 0; i < s.length; ++i) {
            d_l += ++l[s[i] - 'a'] == 1 ? 1 : 0;
            d_r -= --r[s[i] - 'a'] == 0 ? 1 : 0;
            res += d_l == d_r ? 1 : 0;
        }
        return res;
    }
}