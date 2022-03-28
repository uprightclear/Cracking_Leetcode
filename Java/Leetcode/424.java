class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int l = 0, res = 1, base = 0;
        for(int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'A']++;
            base = Math.max(base, cnt[s.charAt(i) - 'A']);
            while(i - l + 1 - base > k) {
                cnt[s.charAt(l++) - 'A']--;
            }
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0, maxf = 0, cnt[] = new int[26];
        for(int i = 0; i < s.length(); i++) {
            maxf = Math.max(maxf, ++cnt[s.charAt(i) - 'A']);
            if(maxf + k > res) res++;
            else --cnt[s.charAt(i - res) - 'A'];
        }
        return res;
    }
}