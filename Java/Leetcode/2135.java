class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> starts = new HashSet<>();
        for(String s : startWords) {
            starts.add(toBinary(s));
        }
        int ans = 0;
        for(String t : targetWords) {
            int target = toBinary(t);
            // 枚举追加的是哪个字母
            for(char c : t.toCharArray()) {
                if(starts.contains(target - (1 << (c - 'a')))) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
    
    public int toBinary(String s) {
        int res = 0;
        for(char c : s.toCharArray()) {
            res += 1 << (c - 'a');
        }
        return res;
    }
}