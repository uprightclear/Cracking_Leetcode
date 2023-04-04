class Solution {
    public int partitionString(String s) {
        int count = 1;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                count++;
                map.clear();
            }
            map.put(s.charAt(i), 1);
        }
        return count;
    }
}