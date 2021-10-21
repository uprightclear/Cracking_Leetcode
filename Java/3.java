class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int r = 0, ans = 0;
        for(int i = 0; i < len; i++) {
            if(i > 0) set.remove(s.charAt(i - 1));
            while(r < len && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            ans = Math.max(ans, r - i);
        }
        return ans;
    }
}


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}