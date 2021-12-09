class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            result = result * 26;
            result += (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}