class Solution {
    List<List<Integer>> pos;
    private boolean isMatch(String word) {
        int l = -1;
        for (char c : word.toCharArray()) {
            List<Integer> p = pos.get(c);
            int index = Collections.binarySearch(p, l + 1);
            if (index < 0) index = -index - 1;
            if (index >= p.size()) return false;
            l = p.get(index);
        }
        return true;
    }
    
    public int numMatchingSubseq(String S, String[] words) {
        pos = new ArrayList<>();
        for (int i = 0; i < 128; ++i) 
            pos.add(new ArrayList<Integer>());
        char[] s = S.toCharArray();
        for (int i = 0; i < s.length; ++i)
            pos.get(s[i]).add(i);
        int ans = 0;
        for (String word : words)
            if (isMatch(word)) ++ans;
        return ans;
    }
}



class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        List<Integer[]>[] waiting = new List[128];
        for (int c = 0; c <= 'z'; c++)
            waiting[c] = new ArrayList();
        for (int i = 0; i < words.length; i++)
            waiting[words[i].charAt(0)].add(new Integer[]{i, 1});
        for (char c : S.toCharArray()) {
            List<Integer[]> advance = new ArrayList(waiting[c]);
            waiting[c].clear();
            for (Integer[] a : advance)
                waiting[a[1] < words[a[0]].length() ? words[a[0]].charAt(a[1]++) : 0].add(a);
        }
        return waiting[0].size();
    }
}