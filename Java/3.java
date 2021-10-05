class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<Character>();
        int r = -1, res = 0;
        for(int i = 0; i < len; i++){
            if(i != 0) set.remove(s.charAt(i - 1));
            while(r + 1 < len && !set.contains(s.charAt(r + 1))){
                set.add(s.charAt(r + 1));
                r++;
            }
            res = Math.max(res, r - i + 1);
        }
        return res;
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