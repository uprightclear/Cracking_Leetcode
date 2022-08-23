class Solution {
    public long appealSum(String s) {
        int last[] = new int[26];
        long res = 0;
        for (int i = 0; i < s.length(); ++i) {
            last[s.charAt(i) - 'a'] = i + 1;
            for (int j : last)
                res += j;
        }
        return res;
    }
}


class Solution {
    public long appealSum(String s) {
        int last[] = new int[26];
        long res = 0, total = 0;
        for (int i = 0; i < s.length(); ++i) {
            total += i + 1 - last[s.charAt(i) - 'a'];
            last[s.charAt(i) - 'a'] = i + 1;
            res += total;
        }
        return res;
    }
}


class Solution {
    public long appealSum(String s) {
        int last[] = new int[26];
        Arrays.fill(last, -1);
        long res = 0, n = s.length();
        for (int i = 0; i < s.length(); ++i) {
            res += (i - last[s.charAt(i) - 'a']) * (n - i);
            last[s.charAt(i) - 'a'] = i;
        }
        return res;
    }
}