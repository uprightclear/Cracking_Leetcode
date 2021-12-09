class Solution {
    public long countVowels(String s) {
        long res = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if ("aeiou".indexOf(s.charAt(i)) >= 0)
                res += (i + 1) * (n - i);
        }
        return res;
    }
}