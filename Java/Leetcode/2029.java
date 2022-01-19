//https://leetcode.com/problems/stone-game-ix/discuss/1500245/JavaC%2B%2BPython-Easy-and-Concise-6-lines-O(n)
class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for (int a: stones)
            cnt[a % 3]++;
        if (Math.min(cnt[1], cnt[2]) == 0)
            return Math.max(cnt[1], cnt[2]) > 2 && cnt[0] % 2 > 0;
        return Math.abs(cnt[1] - cnt[2]) > 2 || cnt[0] % 2 == 0;
    }
}