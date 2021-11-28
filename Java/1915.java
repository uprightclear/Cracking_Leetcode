class Solution {
    public long wonderfulSubstrings(String word) {
        long cnt[] = new long[1024], res = 0;
        int mask = 0;
        cnt[0] = 1;
        for (var ch : word.toCharArray()) {
            //judge the absolute wondeful substring
            mask ^= 1 << (ch - 'a');
            res += cnt[mask];
            //judge the wonderful substring with at most 1 letter appears an odd number
            for (var n = 0; n < 10; ++n)
                res += cnt[mask ^ (1 << n)];
            ++cnt[mask];
        }
        return res;
    }
}