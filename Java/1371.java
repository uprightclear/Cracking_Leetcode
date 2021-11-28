class Solution {
    public int findTheLongestSubstring(String s) {
        int[] index = new int[32];
        int res = 0;
        Arrays.fill(index, -1);
        Map<Character, Integer> map = new HashMap<>();
        int mask = 0;
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)) mask ^= 1 << map.get(c);
            if(mask != 0 && index[mask] == -1) index[mask] = i;
            res = Math.max(res, i - index[mask]);
        }
        return res;
    }
}