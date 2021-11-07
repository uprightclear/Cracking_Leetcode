class Solution {
    public int countVowelSubstrings(String s) {
        int len = s.length();
        Set<Character> dic = new HashSet<>();
        dic.add('a');
        dic.add('e');
        dic.add('i');
        dic.add('o');
        dic.add('u');
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for(int j = 0; j <= len - 5; j++) {
            map = new HashMap<>();
            for(int i = j; i < len; i++) {
                if(dic.contains(s.charAt(i))) {
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                    if(map.size() == 5) ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}