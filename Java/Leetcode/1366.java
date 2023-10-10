class Solution {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        int len = votes[0].length();
        for(String vote : votes) {
            for(int i = 0; i < len; i++) {
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[len]);
                map.get(c)[i]++;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            for(int i = 0; i < len; i++) {
                if(map.get(a)[i] != map.get(b)[i]) return map.get(b)[i] - map.get(a)[i];
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for(char c : list) sb.append(c);
        return sb.toString();
    }
}