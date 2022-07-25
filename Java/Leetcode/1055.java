class Solution {
    public int shortestWay(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        boolean[] map = new boolean[26];
        for (int i = 0; i < cs.length; i++) 
            map[cs[i] - 'a'] = true;
        int j = 0, res = 1;
        for (int i = 0; i < ts.length; i++,j++) {
            if (!map[ts[i] - 'a']) return -1;
            while (j < cs.length && cs[j] != ts[i]) {
                j++;
            }
            if (j == cs.length) {
                j = -1;
                res++;
                i--;
            }
        }
        return res;
    }
}

class Solution {
    public int shortestWay(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        int res = 0;
        for (int i = 0; i < ts.length; ) {
            int oriI = i;
            for (int j = 0; j < cs.length; j++) {
                if (i < ts.length && cs[j] == ts[i])
                    i++;
            }
            if (i == oriI) return -1;
            res++;
        }
        return res;
    }
}


class Solution {
    public int shortestWay(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        int res = 1;
        List<Integer>[] idx = new List[26];
        for (int i = 0; i < 26; i++) idx[i] = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) idx[cs[i] - 'a'].add(i);
        int j = 0;
        for (int i = 0; i < ts.length; ) {
            List<Integer> tar = idx[ts[i] - 'a'];
            if (tar.isEmpty()) return -1;
            int k = Collections.binarySearch(tar,j);
            if (k < 0) k = -k - 1;
            if (k == tar.size()) {
                res++;
                j = 0;
            } else {
                j = tar.get(k) + 1;
                i++;
            }

        }
        return res;
    }
}