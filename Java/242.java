class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] arr = new int[26];

        if(m != n) return false;

        for(int i = 0; i < n; i++){
            arr[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < m; i++){
            if(--arr[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}