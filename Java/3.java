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