class Solution {
    public int minSteps(String s, String t) {
        int[] countS = countLetters(s);
        int[] countT = countLetters(t);
        int ans = 0;
        for(int i = 0; i < 26; i++) {
            ans += Math.max(countS[i], countT[i]) - Math.min(countS[i], countT[i]);
        }
        return ans;
    }
    
    private int[] countLetters(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }
}