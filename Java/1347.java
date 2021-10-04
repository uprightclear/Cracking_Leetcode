class Solution {
    public int minSteps(String s, String t) {
        int[] counts = new int[26];
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++) {
            if(counts[i] > 0) ans += counts[i];
        }
        return ans;
    }
}