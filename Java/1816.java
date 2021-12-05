class Solution {
    public String truncateSentence(String s, int k) {
        int n = s.length();
        int end = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n || s.charAt(i) == ' ') {
                count++;
                if (count == k) {
                    end = i;
                    break;
                }
            }
        }
        return s.substring(0, end);
    }
}