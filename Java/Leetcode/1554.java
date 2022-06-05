class Solution {
    public boolean differByOne(String[] dict) {
        if (dict.length == 2) {
            return helper(dict[0], dict[1]);
        }
        for (int i = 0; i < dict[0].length(); i++) {
            Set<String> set = new HashSet<>();
            for (String s : dict) {
                String key = s.substring(0, i) + s.substring(i + 1);
                if (!set.add(key)) return true;
            }
            set.clear();
        }
        return false;
    }
    private boolean helper(String s, String t) {
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (++j > 1) return false;
            }
        }
        return true;
    }
}

//O(mn)
class Solution {
    public boolean differByOne(String[] dict) {
        int m  = dict.length, n = dict[0].length();
        long[] hash  = new long[m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < dict[i].length(); j++) {
                hash[i] = hash[i] * 26 + dict[i].charAt(j) - 'a';
            }
        }
        Set<Long> set = new HashSet<>();
        long base = 1;
        for(int d = n-1; d>=0; d--) {
            set.clear();
            for(int i = 0; i < m; i++) {
                long tmp = hash[i]- base*(dict[i].charAt(d) - 'a');
                if(!set.add(tmp)) {
                    return true;
                }
            }
            base *= 26;
        }
        return false;
    }
}