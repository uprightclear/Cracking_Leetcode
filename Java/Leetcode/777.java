class Solution {
    public boolean canTransform(String start, String end) {
        
        int i = 0;
        int j = 0;
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();
        
        while (i < s.length || j < e.length)
        {
            // stop at char that is not 'X'
            while (i < s.length && s[i] == 'X') { i++; }
            while (j < e.length && e[j] == 'X') { j++; }
            
            if (i >= s.length || j >= e.length) { break; }
            
            // relative order for 'R' and 'L' in 2 strings should be the same
            if (s[i] != e[j]) return false;
            // R can only move to right
            if (s[i] == 'R' && i > j) return false;
            // L can only move to left
            if (s[i] == 'L' && i < j) return false;
            
            // check next
            i++;
            j++;
        }
        
        return i == j;
    }
}