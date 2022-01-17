class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap <Character, String> map_char = new HashMap();
        HashMap <String, Character> map_word = new HashMap();
        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (!map_char.containsKey(c)) {
                if (map_word.containsKey(w)) {
                    return false;
                } else {
                    map_char.put(c, w);
                    map_word.put(w, c);
                }

            } else {
                String mapped_word = map_char.get(c);
                if (!mapped_word.equals(w))
                    return false;
            }
        }

        return true;
    }
}

class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        int m = str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            String tmp = str.substring(i, j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;
    }
}